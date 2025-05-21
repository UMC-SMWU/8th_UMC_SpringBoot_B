package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.Review.ReviewRequestDTO;
import umc.spring.dto.Review.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.validation.annotation.ValidatedPage;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createReview(@RequestBody ReviewRequestDTO request) {
        reviewService.createReview(request);
        return ResponseEntity.ok(ApiResponse.onSuccess("리뷰 작성 완료"));
    }


    @Operation(summary = "내가 작성한 리뷰 목록 조회 (페이지 1부터 시작)", description = "memberId에 해당하는 리뷰 목록을 1페이지부터 조회합니다.")
    @GetMapping("/my")
    public ApiResponse<ReviewResponseDTO.MyReviewListDTO> getMyReviews(
            @RequestParam Long memberId,
            @ValidatedPage Pageable pageable) {

        ReviewResponseDTO.MyReviewListDTO result = reviewService.getMyReviews(memberId, pageable);
        return ApiResponse.onSuccess(result);
    }
}

