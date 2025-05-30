package umc.nnmrm.web.dto.Review;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateResponseDTO {
    private Long reviewId;
    private LocalDateTime createdAt;
}