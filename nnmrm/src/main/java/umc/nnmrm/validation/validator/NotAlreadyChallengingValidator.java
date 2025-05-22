package umc.nnmrm.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.nnmrm.repository.MemberMissionRepository.MemberMissionRepository;
import umc.nnmrm.validation.annotation.NotAlreadyChallenging;
import umc.nnmrm.apiPayload.code.status.ErrorStatus;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengingValidator implements ConstraintValidator<NotAlreadyChallenging, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long fakeMemberId = 1L; // 하드코딩된 member
        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(fakeMemberId, missionId);

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGED.toString()).addConstraintViolation();
        }

        return !exists;
    }
}
