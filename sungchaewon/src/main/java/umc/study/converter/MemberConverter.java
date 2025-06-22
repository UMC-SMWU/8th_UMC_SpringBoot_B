package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class MemberConverter {

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> throw new IllegalArgumentException("유효하지 않은 gender 값입니다.");
        };

        int age = LocalDate.now().getYear() - request.getBirthYear();

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword()) // 나중에 서비스에서 암호화 예정
                .gender(gender)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())
                .age(age)
                .isDeleted(false)
                .socialType(SocialType.NONE)
                .status(MemberStatus.ACTIVE)
                .nickname("익명") // 또는 request에서 받을 것
                .point(0)
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member) {
        return MemberResponseDTO.MemberInfoDTO.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .build();
    }

}