package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.status.BaseErrorCode;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode); // 부모(GeneralException)의 생성자에 errorCode 전달
    }
}


