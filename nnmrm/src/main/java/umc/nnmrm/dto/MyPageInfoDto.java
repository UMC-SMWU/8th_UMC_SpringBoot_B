package umc.nnmrm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class MyPageInfoDto {
    private String nickname;
    private String email;
    private String phoneStatus;
    private Integer point;
}