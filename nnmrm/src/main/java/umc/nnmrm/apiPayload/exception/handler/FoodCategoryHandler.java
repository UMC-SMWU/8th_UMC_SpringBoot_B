package umc.nnmrm.apiPayload.exception.handler;

import umc.nnmrm.apiPayload.code.BaseErrorCode;
import umc.nnmrm.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
