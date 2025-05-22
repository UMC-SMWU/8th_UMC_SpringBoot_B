package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class HomeMissionDto {
    private Long missionId;
    private String storeName;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
}
