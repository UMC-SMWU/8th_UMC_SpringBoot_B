package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.Request.StoreRequestDTO;
import umc.spring.web.dto.Response.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class MissionConverter {

    public static StoreResponseDTO.CreateMissionResponseDTO toCreateMissionResponseDTO(Mission mission){
        return StoreResponseDTO.CreateMissionResponseDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDto request, Store store) {
        return Mission.builder()
                .store(store)
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .deadline(LocalDate.parse(request.getDeadline()))
                .build();
    }


    public static StoreResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreviewDTO.builder()
                .storeId(mission.getStore().getId())
                .storeName(mission.getStore().getName())
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDTO).toList();

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .missionList(missionPreviewDTOList)
                .listSize(missionPreviewDTOList.size())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .build();
    }


}
