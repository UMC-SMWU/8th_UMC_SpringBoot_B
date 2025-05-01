package umc.nnmrm.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.nnmrm.domain.Region;
import umc.nnmrm.domain.Mission;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<Mission> missions;
}
