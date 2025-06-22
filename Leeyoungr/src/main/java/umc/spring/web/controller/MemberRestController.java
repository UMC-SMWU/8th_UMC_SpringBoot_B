package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.Request.MemberRequestDTO;
import umc.spring.web.dto.Response.MemberResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/join")
    @Operation(summary = "유저 회원가입 API",description = "유저가 회원가입하는 API입니다.")
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

    @GetMapping("/missions/challenging")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API",description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을(size=10) 포함합니다. Query String 으로 page 번호를 주세요 !!")
    public ApiResponse<MemberResponseDTO.ChallengingMissionPreviewListDTO> getMyChallengingMissionList(@ValidPage @Parameter(name = "page", in = ParameterIn.QUERY) Integer page){
        Page<MemberMission> myMissionList = memberQueryService.getChallengingMissionList(page);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengingMissionPreviewListDTO(myMissionList));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }

}
