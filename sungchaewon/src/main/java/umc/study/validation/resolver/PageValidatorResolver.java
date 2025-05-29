package umc.study.validation.resolver;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.validation.annotation.PageValidator;

@Component
@RequiredArgsConstructor
public class PageValidatorResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageValidator.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        String pageParam = webRequest.getParameter("page");
        if (pageParam == null) {
            throw new GeneralException(ErrorStatus._BAD_REQUEST);
        }
        try {
            int page = Integer.parseInt(pageParam);
            if (page < 1) {
                throw new GeneralException(ErrorStatus._BAD_REQUEST);
            }
            return page - 1;
        } catch (NumberFormatException e) {
            throw new GeneralException(ErrorStatus._BAD_REQUEST);
        }
    }
}
