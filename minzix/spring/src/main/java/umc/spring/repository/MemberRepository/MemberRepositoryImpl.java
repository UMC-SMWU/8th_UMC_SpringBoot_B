package umc.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.QMember;
import umc.spring.dto.Member.MemberInfoDto;


@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public MemberInfoDto findUserInfoById(Long userId) {
        QMember member = QMember.member;
        return queryFactory
                .select(
                        com.querydsl.core.types.Projections.constructor(
                                MemberInfoDto.class,
                                member.name,
                                member.email,
//                                member.phoneNum,
                                member.point
                        )
                )
                .from(member)
                .where(member.id.eq(userId))
                .fetchOne();
    }
}
