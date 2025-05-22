package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.web.dto.member.MemberRequestDTO;
import umc.study.web.dto.member.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1 -> gender = Gender.MALE;
            case 2 -> gender = Gender.FEMALE;
            case 3 -> gender = Gender.NONE;
        }

        // 생년월일로 나이 계산
        LocalDate birthDate = LocalDate.of(
                request.getBirthYear(),
                request.getBirthMonth(),
                request.getBirthDay()
        );
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        return Member.builder()
                .name(request.getName())
                .gender(gender)
                .age(age)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())

                // 누락 시 DB 저장 안 되는 필드들
                .email(request.getEmail())
                .socialType(SocialType.NONE) // 예시 값, 실제 요청 값에 따라 바꿔도 됨
                .status(MemberStatus.ACTIVE)  // 기본값으로 ACTIVE 지정

                .memberPreferList(new ArrayList<>()) // builder default 설정
                .build();
    }
}