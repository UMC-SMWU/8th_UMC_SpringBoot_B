package umc.nnmrm.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Region {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regionName;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Store> stores;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<User> users;
}