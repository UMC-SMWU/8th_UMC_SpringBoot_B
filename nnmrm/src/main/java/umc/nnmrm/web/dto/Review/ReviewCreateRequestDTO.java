package umc.nnmrm.web.dto.Review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewCreateRequestDTO {

    @NotNull
    @Min(1)
    @Max(5)
    private Float score;

    @NotBlank
    private String body;
}