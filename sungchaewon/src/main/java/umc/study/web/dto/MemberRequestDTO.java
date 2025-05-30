package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank(message = "공백일 수는 없습니다.")
        String name;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer gender;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer birthYear;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer birthMonth;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer birthDay;
        @NotBlank(message = "공백일 수 없습니다.")
        String email; //누락되어 데이터베이스 연동 실패했었음
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        //화면 렌더링 시 음식 카테고리를 조회하는 API를 호출하고,
        // 그 API의 결과에서 음식 카테고리의 id값을 프론트엔드가 넘겨준다는 것을 전제로 한 것.
        @ExistCategories(message = "FOOD_CATEGORY_NOT_FOUND")
        List<Long> preferCategory;
    }
}
