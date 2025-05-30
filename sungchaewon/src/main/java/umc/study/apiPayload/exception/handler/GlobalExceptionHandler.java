package umc.study.apiPayload.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid 검증 실패
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            // 중복 필드 무시하지 않고 모두 반영 (원하면 덮어쓰기 방지도 가능)
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(
                ApiResponse.onFailure(
                        ErrorStatus._BAD_REQUEST.getCode(),
                        ErrorStatus._BAD_REQUEST.getMessage(),
                        errors
                )
        );
    }

    // JSON 파싱 실패 (ex: 타입 오류, 잘못된 JSON 구조 등)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<?>> handleJsonParseError(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(
                ApiResponse.onFailure(
                        ErrorStatus._BAD_REQUEST.getCode(),
                        "요청 JSON 구조가 잘못되었습니다.",
                        null
                )
        );
    }

    //커스텀 예외 처리 (ex: FoodCategoryHandler)
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralException(GeneralException ex) {
        return ResponseEntity
                .status(ex.getErrorCode().getReasonHttpStatus().getHttpStatus())
                .body(ApiResponse.onFailure(
                        ex.getErrorCode().getReasonHttpStatus().getCode(),
                        ex.getErrorCode().getReasonHttpStatus().getMessage(),
                        null
                ));
    }
}