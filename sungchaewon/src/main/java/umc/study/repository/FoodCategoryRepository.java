package umc.study.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

    // 이름으로 존재 여부 확인 (중복 방지 시 유용)
    boolean existsByName(String name);

    // 이름으로 카테고리 조회
    FoodCategory findByName(String name);
}
