package umc.spring.config.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.apiPayload.code.exception.handler.InvalidPageException;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.ValidatedPage;


@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {

    private static final int DEFAULT_SIZE = 10;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidatedPage.class)
                && parameter.getParameterType().equals(Pageable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        String pageParam = webRequest.getParameter("page");
        int page = 0;

        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
                if (page < 1) {
                    throw new InvalidPageException(ErrorStatus.PAGE_LESS_THAN_ONE);
                }
            } catch (NumberFormatException e) {
                throw new InvalidPageException(ErrorStatus.INVALID_PAGE_FORMAT);
            }
        } else {
            page = 1;
        }

        return PageRequest.of(page - 1, DEFAULT_SIZE);
    }
}
