package umc.study.service.ReviewService;

import umc.study.web.dto.ReviewMyPageListDTO;

public interface ReviewQueryService {
    ReviewMyPageListDTO getMyReviews(Long memberId, Integer page);
}
