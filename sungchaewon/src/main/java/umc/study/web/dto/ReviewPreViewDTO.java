package umc.study.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("ownerNickname")
    private String nickname;

    private Integer score;
    private String body;
    private LocalDate createdAt;
}