package umc.spring.dto.Review;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class ReviewResponseDTO {

    @Getter
    @Builder
    public static class MyReviewDTO {
        private String body;
        private Float score;
        private String storeName;
        private LocalDate createdAt;
    }

    @Getter
    @Builder
    public static class MyReviewListDTO {
        private boolean isFirst;
        private boolean isLast;
        private int totalPage;
        private long totalElements;
        private int listSize;
        private List<MyReviewDTO> reviewList;
    }
}
