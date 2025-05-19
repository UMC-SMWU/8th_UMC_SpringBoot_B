package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.common.annotation.ExistStore;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.dto.Store.StoreRequestDTO;
import umc.spring.dto.Store.StoreResponseDTO;
import umc.spring.service.StoreService.StoreService;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreController { // StoreRestController

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createStore(@RequestBody StoreRequestDTO request) {
        storeService.createStore(request);
        return ResponseEntity.ok(ApiResponse.onSuccess("가게 등록 완료"));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page) {

        // 1. 서비스 계층에서 리뷰 목록 받아오기
        Page<Review> reviewList = storeService.getReviewList(storeId, page);

        // 2. 리뷰 목록을 DTO로 변환
        StoreResponseDTO.ReviewPreViewListDTO responseDTO = StoreConverter.reviewPreViewListDTO(reviewList);

        // 3. ApiResponse로 감싸서 반환
        return ApiResponse.onSuccess(responseDTO);
    }
}
