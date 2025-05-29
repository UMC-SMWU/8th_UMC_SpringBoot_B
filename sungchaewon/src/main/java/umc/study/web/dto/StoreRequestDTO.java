package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class StoreRequestDTO {

    @NotNull(message = "가게 이름은 필수입니다.")
    private String name;

    @NotNull(message = "주소는 필수입니다.")
    private String address;

    @NotNull(message = "카테고리는 필수입니다.")
    private String category;

    private Float score;

    @NotNull(message = "지역 ID는 필수입니다.")
    private Long regionId;
}
