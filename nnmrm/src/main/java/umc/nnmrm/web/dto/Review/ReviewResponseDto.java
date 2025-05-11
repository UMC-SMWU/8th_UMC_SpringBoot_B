package umc.nnmrm.web.dto.Review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ReviewResponseDto{
        private Long reviewId;
        private String memberName;
        private String storeName;
        private Float score;
        private String body;
}