package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(dto.getRating().floatValue())
                .title("리뷰") // 기본 타이틀 지정
                .body(dto.getContent())
                .build();
    }
}
