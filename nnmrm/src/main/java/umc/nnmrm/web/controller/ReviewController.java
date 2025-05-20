package umc.nnmrm.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.nnmrm.apiPayload.ApiResponse;
import umc.nnmrm.service.ReviewService.ReviewService;
import umc.nnmrm.validation.annotation.ExistStore;
import umc.nnmrm.web.dto.Review.ReviewRequestDTO;
import umc.nnmrm.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO> createReview(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO requestDTO
    ) {
        return ApiResponse.onSuccess(reviewService.createReview(storeId, requestDTO));
    }
}