package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.StoreRequestDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/add")
    public ResponseEntity<String> addStore(@RequestBody @Valid StoreRequestDTO storeRequestDTO) {
        storeCommandService.addStore(storeRequestDTO);
        return ResponseEntity.ok("가게가 성공적으로 추가되었습니다.");
    }
}
