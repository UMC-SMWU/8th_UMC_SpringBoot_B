package umc.nnmrm.domain;

package umc.nnmrm.domain.mission;

import jakarta.persistence.*;
import lombok.*;
import umc.nnmrm.domain.common.BaseEntity;
import umc.nnmrm.domain.User;
import umc.nnmrm.domain.Store;
import umc.nnmrm.domain.enums.MissionStatus;
import umc.nnmrm.domain.enums.RewardType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requiredAmount;

    @Enumerated(EnumType.STRING)
    private RewardType rewardType;

    private float rewardAmount;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
