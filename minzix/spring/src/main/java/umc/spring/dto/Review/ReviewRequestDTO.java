package umc.spring.dto.Review;

import lombok.Getter;

@Getter
public class ReviewRequestDTO {
    private String body;
    private Float score;
    private Long storeId;
}
