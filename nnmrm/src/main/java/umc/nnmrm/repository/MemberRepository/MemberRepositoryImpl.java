package umc.nnmrm.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.nnmrm.domain.QMember;
import umc.nnmrm.web.dto.Member.MyPageInfoDto;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public MyPageInfoDto getMyPageInfo(Long memberId) {
        QMember m = QMember.member;

        return queryFactory
                .select(Projections.constructor(MyPageInfoDto.class,
                        m.name,
                        m.email,
                        new CaseBuilder()
                                .when(m.phoneNum.isNull()).then("미인증")
                                .otherwise(m.phoneNum),
                        m.point
                ))
                .from(m)
                .where(m.id.eq(memberId))
                .fetchOne();
    }
}