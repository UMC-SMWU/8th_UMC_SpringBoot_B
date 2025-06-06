package umc.nnmrm.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.apiPayload.code.status.ErrorStatus;
import umc.nnmrm.apiPayload.exception.handler.FoodCategoryHandler;
import umc.nnmrm.converter.MemberConverter;
import umc.nnmrm.converter.MemberPreferConverter;
import umc.nnmrm.domain.FoodCategory;
import umc.nnmrm.domain.Member;
import umc.nnmrm.domain.mapping.MemberPrefer;
import umc.nnmrm.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.nnmrm.repository.MemberRepository.MemberRepository;
import umc.nnmrm.web.dto.Member.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}