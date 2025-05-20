package umc.nnmrm.web.dto.Mission;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MissionRequestDTO {

    @NotNull
    @Min(1000)
    private Integer reward;

    @NotNull
    @Future
    private LocalDate deadline;

    @NotBlank
    private String missionSpec;
}
