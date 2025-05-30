package umc.nnmrm.validation.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.nnmrm.validation.annotation.ValidPage;

@Component
public class ValidPageResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidPage.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        String pageStr = webRequest.getParameter("page");

        if (pageStr == null) {
            throw new IllegalArgumentException("page 파라미터는 필수입니다.");
        }

        int page = Integer.parseInt(pageStr);
        if (page <= 0) {
            throw new IllegalArgumentException("page 파라미터는 1 이상의 숫자여야 합니다.");
        }

        return page - 1;
    }
}