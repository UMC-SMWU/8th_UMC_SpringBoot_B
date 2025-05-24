package umc.spring.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorFactory;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validator(AutowireCapableBeanFactory factory) {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setConstraintValidatorFactory(new ConstraintValidatorFactory() {
            @Override
            public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
                return factory.createBean(key);
            }

            @Override
            public void releaseInstance(ConstraintValidator<?, ?> instance) {}
        });
        return validator;
    }
}

