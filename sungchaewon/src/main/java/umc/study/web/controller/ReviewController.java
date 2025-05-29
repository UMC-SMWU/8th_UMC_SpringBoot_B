package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.ReviewService.ReviewService;
import umc.study.web.dto.ReviewRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.web.dto.ReviewMyPageListDTO;
import umc.study.validation.annotation.PageValidator;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createReview(@RequestBody ReviewRequestDTO requestDTO) {
        // 임시 하드코딩된 member, store
        reviewService.createReview(requestDTO, 1L);

        return ResponseEntity.ok(ApiResponse.onSuccess("리뷰 등록 성공"));
    }

    @Operation(summary = "내가 작성한 리뷰 목록 조회", description = "로그인한 사용자의 리뷰 목록을 페이징 처리하여 조회합니다.")
    @GetMapping("/me")
    public ApiResponse<ReviewMyPageListDTO> getMyReviews(@RequestParam @PageValidator Integer page) {
        Long fakeMemberId = 1L; // 임시 memberId
        return ApiResponse.onSuccess(reviewQueryService.getMyReviews(fakeMemberId, page));
    }
}