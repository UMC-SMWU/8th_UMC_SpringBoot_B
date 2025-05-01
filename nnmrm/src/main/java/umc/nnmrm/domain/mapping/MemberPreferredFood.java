package umc.nnmrm.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.nnmrm.domain.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberPreferredFood {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
