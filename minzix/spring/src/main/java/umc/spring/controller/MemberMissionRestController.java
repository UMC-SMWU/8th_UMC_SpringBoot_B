package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.memberMission.MemberMissionResponseDTO;
import umc.spring.service.MemberMissionService.MemberMissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
@Tag(name = "MemberMission", description = "멤버의 미션 관련 API")
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    @Operation(summary = "내가 진행 중인 미션 목록 조회", description = "memberId에 해당하는 진행 중(CHALLENGING) 미션을 조회합니다. size는 고정(10)")
    @GetMapping("/in-progress")
    public ApiResponse<MemberMissionResponseDTO.InProgressMissionListDTO> getInProgressMissions(
            @RequestParam Long memberId,
            @RequestParam @Min(1) int page // 1-based로 받되, 내부에선 0-based로 처리
    ) {
        int pageIndex = page - 1; // 1-based → 0-based 변환
        int size = 10; // 고정 사이즈

        Pageable pageable = PageRequest.of(pageIndex, size, Sort.by("createdAt").descending());

        return ApiResponse.onSuccess(memberMissionService.getInProgressMissions(memberId, pageable));
    }


    @PatchMapping("/{memberId}/missions/{missionId}")
    @Operation(summary = "진행 중 미션 완료 처리", description = "진행 중인 미션 상태를 COMPLETE로 변경합니다.")
    public ApiResponse<String> completeMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId
    ) {
        memberMissionService.completeMission(memberId, missionId);
        return ApiResponse.onSuccess("미션 완료 처리 성공");
    }
}
