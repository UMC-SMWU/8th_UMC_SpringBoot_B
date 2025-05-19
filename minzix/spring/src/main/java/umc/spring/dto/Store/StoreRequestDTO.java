package umc.spring.dto.Store;

import lombok.Getter;

@Getter
public class StoreRequestDTO {
    private String name;
    private String address;
    private Float score;
    private Long regionId;
}