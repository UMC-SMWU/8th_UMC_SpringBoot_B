package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.Store;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String category;

    public static StoreResponseDTO from(Store store) {
        return StoreResponseDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .category(store.getCategory())
                .build();
    }
}
