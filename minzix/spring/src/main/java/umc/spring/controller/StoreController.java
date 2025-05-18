package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.Store.StoreRequestDTO;
import umc.spring.service.StoreService.StoreService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createStore(@RequestBody StoreRequestDTO request) {
        storeService.createStore(request);
        return ResponseEntity.ok(ApiResponse.onSuccess("가게 등록 완료"));
    }
}
