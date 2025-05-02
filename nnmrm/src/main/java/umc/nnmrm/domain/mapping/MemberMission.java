package umc.nnmrm.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.nnmrm.domain.common.BaseEntity;
import umc.nnmrm.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
}
