package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.validation.annotation.PageValidator;
import umc.study.web.dto.OngoingMissionListDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {

    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/my-ongoing")
    public ApiResponse<OngoingMissionListDTO> getMyOngoingMissions(
            @RequestParam @PageValidator Integer page) {
        Long fakeMemberId = 1L; // 로그인 안 되어있으면 임시로 사용
        Pageable pageable = PageRequest.of(page - 1, 10);
        return ApiResponse.onSuccess(memberMissionQueryService.getOngoingMissions(fakeMemberId, pageable));
    }
}
