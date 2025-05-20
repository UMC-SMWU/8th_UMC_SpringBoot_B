package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.Review.ReviewRequestDTO;
import umc.spring.dto.Review.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewService;

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


    @GetMapping("/my")
    public ApiResponse<ReviewResponseDTO.MyReviewListDTO> getMyReviews(
            @RequestParam Long memberId,
            @PageableDefault(size = 10) Pageable pageable) {

        ReviewResponseDTO.MyReviewListDTO result = reviewService.getMyReviews(memberId, pageable);
        return ApiResponse.onSuccess(result);
    }
}

