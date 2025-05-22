package umc.study.apiPayload.exception.handler;


import umc.study.apiPayload.exception.GeneralException;
import umc.study.apiPayload.code.status.ErrorStatus;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(ErrorStatus status) {
        super(status);
    }
}
