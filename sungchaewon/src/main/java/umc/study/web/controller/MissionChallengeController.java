package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.service.MissionService.MissionChallengeService;
import umc.study.web.dto.MissionChallengeRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionChallengeController {

    private final MissionChallengeService missionChallengeService;

    @PostMapping("/challenge")
    public ResponseEntity<String> challengeMission(@RequestBody @Valid MissionChallengeRequestDTO requestDTO) {
        Long hardcodedMemberId = 1L;  // 하드코딩된 멤버 ID
        missionChallengeService.challengeMission(hardcodedMemberId, requestDTO.getMissionId());
        return ResponseEntity.ok("미션 도전 완료");
    }
}