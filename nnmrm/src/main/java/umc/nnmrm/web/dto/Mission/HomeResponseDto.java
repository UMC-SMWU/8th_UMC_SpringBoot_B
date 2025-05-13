package umc.nnmrm.web.dto.Mission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public class HomeResponseDto {
    private Long missionId;
    private Integer reward;
    private String missionSpec;
    private LocalDate deadline;
    private String storeName;
    private String storeAddress;
    private String cursorValue;
}