package umc.nnmrm.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.nnmrm.apiPayload.ApiResponse;
import umc.nnmrm.converter.MissionChallengeConverter;
import umc.nnmrm.domain.Mission;
import umc.nnmrm.service.MemberMissionService.MemberMissionCommandService;
import umc.nnmrm.service.MissionService.MissionCommandService;
import umc.nnmrm.validation.annotation.ExistMember;
import umc.nnmrm.validation.annotation.ExistMission;
import umc.nnmrm.validation.annotation.NotAlreadyChallenging;
import umc.nnmrm.validation.annotation.ValidPage;
import umc.nnmrm.web.dto.MemberMission.MissionChallengeResponseDTO;
import umc.nnmrm.web.dto.Mission.MissionResponseDTO;

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

    @GetMapping("/members/{memberId}/missions/in-progress")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "특정 유저가 진행 중인 미션 목록을 페이징하여 조회합니다. 쿼리 스트링으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디"),
            @Parameter(name = "page", description = "1부터 시작하는 페이지 번호")
    })
    public ApiResponse<MissionResponseDTO.MyMissionListDTO> getMissionList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @ValidPage Integer page
    ) {
        Page<Mission> missionPage = memberMissionService.getMyInProgressMissions(memberId, page);
        return ApiResponse.onSuccess(MissionChallengeConverter.toMyMissionListDTO(missionPage));
    }

}
