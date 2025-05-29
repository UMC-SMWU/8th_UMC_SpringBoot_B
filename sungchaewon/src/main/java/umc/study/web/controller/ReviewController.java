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

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createReview(@RequestBody ReviewRequestDTO requestDTO) {
        // 임시 하드코딩된 member, store
        reviewService.createReview(requestDTO, 1L);

        return ResponseEntity.ok(ApiResponse.onSuccess("리뷰 등록 성공"));
    }
}