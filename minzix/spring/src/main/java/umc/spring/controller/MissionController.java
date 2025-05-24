package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.Mission.MissionJoinRequestDTO;
import umc.spring.dto.Mission.MissionRequestDTO;
import umc.spring.dto.Mission.MissionResponseDTO;
import umc.spring.service.MissionService.MissionService;
import umc.spring.validation.annotation.ValidatedPage;

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


    @Operation(summary = "특정 가게의 미션 목록 조회", description = "가게 ID와 페이지 번호를 입력 받아 미션 목록을 반환합니다. size는 고정(10)")
    @GetMapping("/store")
    public ApiResponse<MissionResponseDTO.MissionListDTO> getMissionsByStore(
            @RequestParam Long storeId,
            @RequestParam @Min(1) int page // 1부터 시작하는 page 번호를 받음
    ) {
        int pageIndex = page - 1; // 0-based 처리
        int size = 10; // 고정된 size 값

        Pageable pageable = PageRequest.of(pageIndex, size, Sort.by("createdAt").descending());

        return ApiResponse.onSuccess(missionService.getMissionsByStore(storeId, pageable));
    }

}

