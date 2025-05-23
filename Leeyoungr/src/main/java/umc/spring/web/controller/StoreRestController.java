package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.Request.StoreRequestDTO;
import umc.spring.web.dto.Response.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/mission")
    public ApiResponse<StoreResponseDTO.CreateMissionResponseDTO> createMission(@RequestBody @Valid StoreRequestDTO.MissionDto request){
        Mission mission = storeCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResponseDTO(mission));
    }
}
