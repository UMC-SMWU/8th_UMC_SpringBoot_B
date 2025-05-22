package umc.spring.dto.MissionList;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MissionListDto {
    private String storeName;
    private LocalDate dDay;
    private String missionContent;
    private Integer reward;
    private Long missionId;
}
