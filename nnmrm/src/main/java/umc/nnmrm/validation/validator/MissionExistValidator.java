package umc.nnmrm.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.nnmrm.repository.MissionRepository.MissionRepository;
import umc.nnmrm.validation.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    private final MissionRepository missionRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return missionRepository.existsById(value);
    }
}