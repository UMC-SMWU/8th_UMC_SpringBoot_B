package umc.nnmrm.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.nnmrm.validation.validator.NotAlreadyChallengingValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotAlreadyChallengingValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotAlreadyChallenging {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}