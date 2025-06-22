package umc.nnmrm.web.dto.Member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.nnmrm.domain.enums.Role;
import umc.nnmrm.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Setter
    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;    // 이메일 필드 추가
        @NotBlank
        String password;    // 비밀번호 필드 추가
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        List<Long> preferCategory;
        @NotNull
        Role role;    // 역할 필드 추가
    }
}