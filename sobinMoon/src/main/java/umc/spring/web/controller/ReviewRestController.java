package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.converter.ReviewConverter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
     private final ReviewCommandService reviewCommandService;

     @PostMapping("/")
     public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDTO request) {
         Review review = reviewCommandService.joinReview(request);
         return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
     }
}
