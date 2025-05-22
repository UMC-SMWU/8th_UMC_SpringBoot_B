package umc.spring.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberInfoDto {
    private String name;
    private String email;
//    private String phoneNum;
    private Integer point;
}
