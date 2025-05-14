package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.exception.GeneralException;
import umc.spring.apiPayload.code.exception.BaseErrorCode;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}


