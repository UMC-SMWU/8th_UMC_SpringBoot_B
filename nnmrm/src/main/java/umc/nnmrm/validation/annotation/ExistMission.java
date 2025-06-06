package umc.nnmrm.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.nnmrm.validation.validator.MissionExistValidator;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = MissionExistValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {
    String message() default "존재하지 않는 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}