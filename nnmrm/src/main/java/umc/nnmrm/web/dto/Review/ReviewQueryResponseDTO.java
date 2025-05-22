package umc.nnmrm.web.dto.Review;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReviewQueryResponseDTO {
        private Long reviewId;
        private String memberName;
        private String storeName;
        private Float score;
        private String body;
}