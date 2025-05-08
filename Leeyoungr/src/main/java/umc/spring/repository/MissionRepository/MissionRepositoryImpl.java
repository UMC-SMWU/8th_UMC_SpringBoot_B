package umc.spring.repository.MissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.web.dto.HomeMissionDto;

import java.util.List;

@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<HomeMissionDto> findMissionsByRegion(Long memberId, String regionName, Long cursorId, int limit) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        return queryFactory
                .select(Projections.constructor(
                        HomeMissionDto.class,
                        mission.id,
                        store.name,
                        mission.reward,
                        mission.deadline,
                        mission.missionSpec
                ))
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        region.name.eq(regionName),
                        cursorId == null ? null : mission.id.gt(cursorId),
                        JPAExpressions
                                .selectOne()
                                .from(memberMission)
                                .where(
                                        memberMission.mission.id.eq(mission.id),
                                        memberMission.member.id.eq(memberId)
                                )
                                .notExists()
                )
                .orderBy(mission.id.asc())
                .limit(limit)
                .fetch();
    }
}