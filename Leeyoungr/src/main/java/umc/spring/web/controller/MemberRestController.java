package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.Request.MemberRequestDTO;
import umc.spring.web.dto.Response.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/reviews")
    public ApiResponse<MemberResponseDTO.CreateReviewResponseDTO> createReview (@RequestBody @Valid MemberRequestDTO.ReviewDto request){
        Review review = memberCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReivewResponseDTO(review));
    }

    @GetMapping("/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을(size=10) 포함합니다. Query String 으로 page 번호를 주세요 !!")
    public ApiResponse<MemberResponseDTO.MyReviewPreViewListDTO> getMyReviewList(@ValidPage @Parameter(name = "page", in = ParameterIn.QUERY) Integer page){
        Page<Review> myReviewList = memberQueryService.getMyReviewList(page);
        return ApiResponse.onSuccess(ReviewConverter.myReviewPreviewListDTO(myReviewList));
    }

}
