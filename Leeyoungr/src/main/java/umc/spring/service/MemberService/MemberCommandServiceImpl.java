package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.Request.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

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

    @Override
    @Transactional
    public Review createReview(MemberRequestDTO.ReviewDto request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, store);

        return reviewRepository.save(review);
    }
}
