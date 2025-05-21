package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotBlank
        private String missionSpec;
        @NotNull
        private Integer reward;
        @NotNull
        private LocalDateTime deadline;
    }
}
