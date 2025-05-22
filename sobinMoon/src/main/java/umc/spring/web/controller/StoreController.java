package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@Validated
public class StoreController {
    private final MissionCommandService missionCommandService;

    @PostMapping("{storeId}/missions")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MissionRequestDTO.JoinDTO request,
            @ExistStore @PathVariable(name="storeId") Long storeId
    ){
        Mission mission = missionCommandService.joinMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toDTO(mission));
    }
}
