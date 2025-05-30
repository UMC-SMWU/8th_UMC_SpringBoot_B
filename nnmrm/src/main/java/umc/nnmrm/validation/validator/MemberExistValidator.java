package umc.nnmrm.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.nnmrm.repository.MemberRepository.MemberRepository;
import umc.nnmrm.validation.annotation.ExistMember;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {

    private final MemberRepository memberRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return memberRepository.existsById(value);
    }
}