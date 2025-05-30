package umc.study.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.List;

@Getter
public class ReviewRequestDTO {

    @NotNull(message = "storeId는 필수입니다.")
    private Long storeId;

    @NotBlank(message = "리뷰 내용은 필수입니다.")
    private String content;

    @NotNull(message = "별점은 필수입니다.")
    @Min(value = 0, message = "별점은 0 이상이어야 합니다.")
    @Max(value = 5, message = "별점은 5 이하여야 합니다.")
    private Integer rating;

    // 선택적으로 이미지 URL 리스트 추가
    private List<String> imageUrls;
}