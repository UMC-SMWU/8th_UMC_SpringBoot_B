package umc.nnmrm.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.nnmrm.apiPayload.ApiResponse;
import umc.nnmrm.service.MemberMissionService.MemberMissionCommandService;
import umc.nnmrm.validation.annotation.ExistMission;
import umc.nnmrm.validation.annotation.NotAlreadyChallenging;
import umc.nnmrm.web.dto.MemberMission.MissionChallengeResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionChallengeResponseDTO> challengeMission(
            @PathVariable("missionId") @ExistMission @NotAlreadyChallenging Long missionId
    ) {
        return ApiResponse.onSuccess(memberMissionService.challengeMission(missionId));
    }

}
