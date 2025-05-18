package umc.nnmrm.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.nnmrm.apiPayload.ApiResponse;
import umc.nnmrm.service.MissionService.MissionCommandService;
import umc.nnmrm.validation.annotation.ExistStore;
import umc.nnmrm.web.dto.Mission.MissionRequestDTO;
import umc.nnmrm.web.dto.Mission.MissionResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionController {

    private final MissionCommandService missionService;

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO> createMission(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO requestDTO
    ) {
        return ApiResponse.onSuccess(missionService.createMission(storeId, requestDTO));
    }
}