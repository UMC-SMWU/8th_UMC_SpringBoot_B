package umc.spring.common.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CommonHandler;
import umc.spring.common.annotation.PageFromOne;

@Component
public class PageFromOneArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageFromOne.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String pageParam = webRequest.getParameter("page"); // <-- 직접 읽기
        int page = Integer.parseInt(pageParam);
        if (page < 1) throw new CommonHandler(ErrorStatus.PAGE_NOT_VALID);
        return page - 1;
    }
}
