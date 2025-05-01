package umc.nnmrm.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.nnmrm.domain.mapping.MemberPreferredFood;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberPreferredFood> preferredBy = new ArrayList<>();
}