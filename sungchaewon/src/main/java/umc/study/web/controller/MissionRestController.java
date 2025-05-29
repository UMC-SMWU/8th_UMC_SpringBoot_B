package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionChallengeService;
import umc.study.web.dto.MissionChallengeRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionChallengeService missionChallengeService;

    @PostMapping("/challenge")
    public ApiResponse<String> challengeMission(@RequestBody @Valid MissionChallengeRequestDTO request) {
        Long hardcodedMemberId = 1L; // 로그인 없으므로 하드코딩
        missionChallengeService.challengeMission(hardcodedMemberId, request.getMissionId());
        return ApiResponse.onSuccess("미션 도전이 완료되었습니다.");
    }
}
