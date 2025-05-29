package umc.study.service.ReviewService;

import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewService {
    void createReview(ReviewRequestDTO requestDTO, Long memberId);
}
