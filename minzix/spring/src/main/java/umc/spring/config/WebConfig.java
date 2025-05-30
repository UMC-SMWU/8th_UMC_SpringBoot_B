package umc.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import umc.spring.config.resolver.PageArgumentResolver;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final PageArgumentResolver pageArgumentResolver;

    public WebConfig(PageArgumentResolver pageArgumentResolver) {
        this.pageArgumentResolver = pageArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(pageArgumentResolver);
    }
}
