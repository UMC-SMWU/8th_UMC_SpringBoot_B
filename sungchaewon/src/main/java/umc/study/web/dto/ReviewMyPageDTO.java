package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewMyPageDTO {
    private String storeName;
    private Float score;
    private String body;
    private LocalDate createdAt;
    private List<String> imageUrls;
    private String ownerComment; // nullable


}
