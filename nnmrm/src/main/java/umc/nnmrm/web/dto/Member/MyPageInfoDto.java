package umc.nnmrm.web.dto.Member;

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