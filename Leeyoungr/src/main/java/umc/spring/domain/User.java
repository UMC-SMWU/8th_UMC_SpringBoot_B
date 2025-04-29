package umc.spring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.UserStatus;
import umc.spring.domain.enums.SocialType;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mapping.UserPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank   // @NotBlank는 hibernate에서 별도의 DDL 제공하지 않기 때문에,  @Column(nullable = false) 추가 작성
    @Column(nullable = false, length = 20)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String address;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private UserStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    private LocalDate birth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPrefer> userPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

}
