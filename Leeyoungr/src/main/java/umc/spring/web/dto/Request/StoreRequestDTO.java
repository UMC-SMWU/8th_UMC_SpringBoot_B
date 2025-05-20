package umc.spring.web.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

public class StoreRequestDTO {

    @Getter
    public static class MissionDto {
        @NotNull
        @ExistStore
        Long storeId;
        @NotNull
        Integer reward;
        @Size(max = 100)
        String missionSpec;
        @NotBlank
        String deadline;
    }
}
