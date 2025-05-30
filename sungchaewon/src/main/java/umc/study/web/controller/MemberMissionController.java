package umc.study.web.controller;

import umc.study.service.MemberMissionService.MemberMissionCommandService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.validation.annotation.PageValidator;
import umc.study.web.dto.OngoingMissionListDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {

    private final MemberMissionQueryService memberMissionQueryService;
    private final MemberMissionCommandService memberMissionCommandService;

    @GetMapping("/my-ongoing")
    public ApiResponse<OngoingMissionListDTO> getMyOngoingMissions(
            @RequestParam @PageValidator Integer page) {
        Long fakeMemberId = 1L; // 로그인 안 되어있으면 임시로 사용
        Pageable pageable = PageRequest.of(page - 1, 10);
        return ApiResponse.onSuccess(memberMissionQueryService.getOngoingMissions(fakeMemberId, pageable));
    }

    @PatchMapping("/complete/{memberMissionId}")
    public ApiResponse<String> completeMission(@PathVariable Long memberMissionId) {
        memberMissionCommandService.completeMission(memberMissionId);
        return ApiResponse.onSuccess("진행 완료 처리되었습니다.");
    }
}
