package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.Request.StoreRequestDTO;
import umc.spring.web.dto.Response.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;


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
}
