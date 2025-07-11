package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.dto.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 예시
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),
    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // Region 관련 에러
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "해당 지역을 찾을 수 없습니다."),

    // Store 관련 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "해당 가게를 찾을 수 없습니다."),

    // Mission 관련 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "Mission4001", "해당 미션을 찾을 수 없습니다."),

    // FoodCategory 관련 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOODCATEGORY4001", "해당 음식 카테고리를 찾을 수 없습니다."),

    // Paging 관련 에러
    INVALID_PAGE_FORMAT(HttpStatus.BAD_REQUEST, "PAGE4001", "페이지 번호 형식이 잘못되었습니다."),
    PAGE_LESS_THAN_ONE(HttpStatus.BAD_REQUEST, "PAGE4002", "페이지 번호는 1 이상이어야 합니다."),

    // Mission complete 관련 에러
    MEMBER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MM404", "해당 멤버의 미션이 존재하지 않습니다."),
    MISSION_ALREADY_COMPLETE(HttpStatus.BAD_REQUEST, "MM400", "이미 완료된 미션입니다."),

    // 비밀번호 틀렸을 때 오류
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "M001", "비밀번호가 올바르지 않습니다."),

    // token 관련 오류
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "AT400", "유효하지 않은 토큰입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }
    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}