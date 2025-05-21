package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.memberMission.MemberMissionResponseDTO;
import umc.spring.service.MemberMissionService.MemberMissionService;
import umc.spring.validation.annotation.ValidatedPage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
@Tag(name = "MemberMission", description = "멤버의 미션 관련 API")
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    @Operation(summary = "내가 진행 중인 미션 목록 조회", description = "memberId에 해당하는 진행 중(CHALLENGING) 미션을 페이징하여 조회합니다.")
    @GetMapping("/in-progress")
    public ApiResponse<MemberMissionResponseDTO.InProgressMissionListDTO> getInProgressMissions(
            @RequestParam Long memberId,
            @ValidatedPage Pageable pageable) {

        return ApiResponse.onSuccess(memberMissionService.getInProgressMissions(memberId, pageable));
    }
}
