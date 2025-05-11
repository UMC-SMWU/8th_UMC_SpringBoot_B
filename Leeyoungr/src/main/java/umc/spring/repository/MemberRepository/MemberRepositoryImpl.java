package umc.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.web.dto.MyPageInfoDto;
import static com.querydsl.core.types.Projections.constructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public MyPageInfoDto findMyPageInfoById(Long memberId) {
        QMember member = QMember.member;

        return queryFactory
                .select(constructor(
                        MyPageInfoDto.class,
                        member.name,
                        member.email,
                        member.phoneNum,
                        member.point
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}