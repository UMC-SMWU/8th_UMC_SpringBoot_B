package umc.spring.service.FoodCategoryValidationService;

import java.util.List;

public interface FoodCategoryValidationService {
    boolean allExist(List<Long> categoryIds);
}