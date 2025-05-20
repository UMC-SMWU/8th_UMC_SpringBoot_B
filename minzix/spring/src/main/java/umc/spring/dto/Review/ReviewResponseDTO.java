package umc.spring.dto.Review;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class ReviewResponseDTO {

    @Getter
    @Builder
    public static class MyReviewDTO {
        private String body;
        private Float score;
        private String storeName;
        private LocalDate createdAt;
    }
}
