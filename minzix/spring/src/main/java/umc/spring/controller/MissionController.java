package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.Mission.MissionJoinRequestDTO;
import umc.spring.dto.Mission.MissionRequestDTO;
import umc.spring.service.MissionService.MissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createMission(@RequestBody MissionRequestDTO request) {
        missionService.createMission(request);
        return ResponseEntity.ok(ApiResponse.onSuccess("미션 등록 완료"));
    }

    @PostMapping("/join")
    public ResponseEntity<ApiResponse<?>> joinMission(@RequestBody MissionJoinRequestDTO request) {
        missionService.joinMission(request);
        return ResponseEntity.ok(ApiResponse.onSuccess("미션 도전 완료"));
    }
}

