package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPreViewDTO {
    private Long id;
    private String nickname;
    private Float score;
    private String body;
    private LocalDate createdAt;
}
