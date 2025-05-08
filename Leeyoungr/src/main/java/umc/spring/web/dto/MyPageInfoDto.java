package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class MyPageInfoDto {
    private String name;
    private String email;
    private String phoneNum;
    private Integer point;
}