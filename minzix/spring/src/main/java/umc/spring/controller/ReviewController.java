package umc.spring.controller;

import lombok.RequiredArgsConstructor;
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
    public ApiResponse<List<ReviewResponseDTO.MyReviewDTO>> getMyReviews(@RequestParam Long memberId) {
        List<ReviewResponseDTO.MyReviewDTO> result = reviewService.getMyReviews(memberId);
        return ApiResponse.onSuccess(result);
    }
}

