package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotation.PageValidator;
import umc.study.web.dto.MissionListDTO;
import umc.study.web.dto.MissionRequestDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/add")
    public ResponseEntity<String> addMission(@RequestBody @Valid MissionRequestDTO dto) {
        missionCommandService.addMission(dto);
        return ResponseEntity.ok("미션이 성공적으로 추가되었습니다.");
    }

    @GetMapping("/store/{storeId}")
    public ApiResponse<MissionListDTO> getMissionsByStore(
            @PathVariable Long storeId,
            @RequestParam @PageValidator Integer page) {

        Pageable pageable = PageRequest.of(page - 1, 10);
        return ApiResponse.onSuccess(missionQueryService.getMissionsByStore(storeId, pageable));
    }
}
