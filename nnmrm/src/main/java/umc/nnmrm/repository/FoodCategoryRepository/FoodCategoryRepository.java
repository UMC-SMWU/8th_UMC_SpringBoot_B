package umc.nnmrm.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.nnmrm.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
