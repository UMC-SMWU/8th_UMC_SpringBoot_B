package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDTO {

        @ExistMember
        Long memberId;

        @ExistStore
        Long storeId;

        @Size(min=20, max=1000)
        String body;

        @DecimalMin("0.0")
        @DecimalMax("5.0")
        Float score;
    }
}
