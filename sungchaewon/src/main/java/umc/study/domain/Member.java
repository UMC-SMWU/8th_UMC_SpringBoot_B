package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.Role;
import umc.study.domain.enums.SocialType;
import umc.study.domain.enums.mapping.MemberAgree;
import umc.study.domain.enums.mapping.MemberMission;
import umc.study.domain.enums.mapping.MemberPrefer;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔑 인코딩된 비밀번호만 사용
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'", nullable = false)
    private MemberStatus status;

    private LocalDate inactiveDate;

    @ColumnDefault("0")
    private Integer point;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    public void encodePassword(String password) {
        this.password = password;
    }

    public String getEncodedPassword() {
        return this.password;
    }

    public String getPassword() {
        return password;
    }

    // 🏗 정적 팩토리 메서드
    public static Member of(String password, String name, String nickname, Boolean isDeleted,
                            String address, String specAddress, Integer age,
                            SocialType socialType, MemberStatus status, String email, Role role, Gender gender) {
        return Member.builder()
                .password(password)
                .name(name)
                .nickname(nickname)
                .isDeleted(isDeleted)
                .address(address)
                .specAddress(specAddress)
                .age(age)
                .socialType(socialType)
                .status(status)
                .email(email)
                .role(role)
                .gender(gender)
                .point(0)
                .build();
    }
}