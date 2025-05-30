package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponseDTO {

    private Long id;
    private String content;
    private int rating;
    private String storeName;
    private String createdAt;
}
