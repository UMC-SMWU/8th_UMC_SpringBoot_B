package umc.nnmrm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 453840827L;

    public static final QMember member = new QMember("member1");

    public final umc.nnmrm.domain.common.QBaseEntity _super = new umc.nnmrm.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.nnmrm.domain.enums.Gender> gender = createEnum("gender", umc.nnmrm.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc.nnmrm.domain.mapping.MemberAgree, umc.nnmrm.domain.mapping.QMemberAgree> memberAgreeList = this.<umc.nnmrm.domain.mapping.MemberAgree, umc.nnmrm.domain.mapping.QMemberAgree>createList("memberAgreeList", umc.nnmrm.domain.mapping.MemberAgree.class, umc.nnmrm.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.nnmrm.domain.mapping.MemberMission, umc.nnmrm.domain.mapping.QMemberMission> memberMissionList = this.<umc.nnmrm.domain.mapping.MemberMission, umc.nnmrm.domain.mapping.QMemberMission>createList("memberMissionList", umc.nnmrm.domain.mapping.MemberMission.class, umc.nnmrm.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.nnmrm.domain.mapping.MemberPrefer, umc.nnmrm.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.nnmrm.domain.mapping.MemberPrefer, umc.nnmrm.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.nnmrm.domain.mapping.MemberPrefer.class, umc.nnmrm.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.nnmrm.domain.enums.Role> role = createEnum("role", umc.nnmrm.domain.enums.Role.class);

    public final EnumPath<umc.nnmrm.domain.enums.SocialType> socialType = createEnum("socialType", umc.nnmrm.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.nnmrm.domain.enums.MemberStatus> status = createEnum("status", umc.nnmrm.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

