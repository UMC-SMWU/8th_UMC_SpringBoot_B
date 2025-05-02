package umc.nnmrm.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.nnmrm.domain.common.BaseEntity;
import umc.nnmrm.domain.mapping.MemberMission;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false, length = 100)
    private String missionSpec;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();
}