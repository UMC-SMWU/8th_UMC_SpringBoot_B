package umc.spring.service.FoodCategoryValidationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryValidationServiceImpl implements FoodCategoryValidationService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean allExist(List<Long> categoryIds) {
        return categoryIds.stream().allMatch(foodCategoryRepository::existsById);
    }
}
