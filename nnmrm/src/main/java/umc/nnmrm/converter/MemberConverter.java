package umc.nnmrm.converter;

import umc.nnmrm.domain.Member;
import umc.nnmrm.domain.enums.Gender;
import umc.nnmrm.web.dto.Member.MemberRequestDTO;
import umc.nnmrm.web.dto.Member.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender;

        Integer genderValue = request.getGender();
        if (genderValue == null) {
            throw new IllegalArgumentException("성별은 필수 입력입니다.");
        }

        switch (genderValue) {
            case 1 -> gender = Gender.MALE;
            case 2 -> gender = Gender.FEMALE;
            case 3 -> gender = Gender.NONE;
            default -> throw new IllegalArgumentException("성별 값이 올바르지 않습니다.");
        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(gender)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}