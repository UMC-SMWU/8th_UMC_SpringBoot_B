package umc.nnmrm.repository.MissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.nnmrm.domain.QMission;
import umc.nnmrm.domain.QRegion;
import umc.nnmrm.domain.QStore;
import umc.nnmrm.domain.mapping.QMemberMission;
import umc.nnmrm.web.dto.Mission.HomeResponseDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    QMission m = QMission.mission;
    QStore s = QStore.store;
    QRegion r = QRegion.region;
    QMemberMission mm = QMemberMission.memberMission;

    @Override
    public List<HomeResponseDto> findAvailableMissions(Long memberId, Long regionId, String cursorId, int limit) {

        BooleanExpression cursorCondition = cursorId != null
                ? m.id.lt(Long.valueOf(cursorId))
                : null;

        return queryFactory
                .select(Projections.constructor(HomeResponseDto.class,
                        m.id,
                        m.reward,
                        m.missionSpec,
                        m.deadline,
                        s.name,
                        s.address,
                        Expressions.constant("")
                ))
                .from(m)
                .join(m.store, s)
                .join(s.region, r)
                .leftJoin(mm).on(mm.member.id.eq(memberId).and(mm.mission.id.eq(m.id)))
                .where(
                        r.id.eq(regionId),
                        mm.id.isNull(),
                        cursorCondition
                )
                .orderBy(m.id.desc()) // 최신순 정렬
                .limit(limit)
                .fetch();
    }
}
