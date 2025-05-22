package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequestMapping("missions")
@RequiredArgsConstructor
@Validated
public class MissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{missionId}/join")
    public ApiResponse<MemberMissionResponseDTO.JoinResultDTO> joinMission(
            @PathVariable(name="missionId") @ExistMission Long missionId,
            @RequestBody @Valid MemberMissionRequestDTO.JoinDTO request
    ) {
        MemberMission memberMission = memberMissionCommandService.join(request, missionId);

        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission.getId()));
    }
}
