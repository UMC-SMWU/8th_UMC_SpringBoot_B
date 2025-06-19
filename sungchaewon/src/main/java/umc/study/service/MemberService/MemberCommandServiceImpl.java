package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberPreferConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.enums.mapping.MemberPrefer;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        System.out.println("[SERVICE] joinMember() 실행 시작");

        // 회원 객체 생성 및 비밀번호 인코딩
        Member newMember = MemberConverter.toMember(request);
        System.out.println("➡ 생성된 Member 객체: " + newMember);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        // 선호 음식 카테고리 설정
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(categoryId -> foodCategoryRepository.findById(categoryId)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        // MemberPrefer 객체 생성 및 양방향 연관관계 설정
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> memberPrefer.setMember(newMember));
        newMember.getMemberPreferList().addAll(memberPreferList);

        // 최종 저장
        return memberRepository.save(newMember);
    }
}