package umc.study.repository.MissionRepository;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.mapping.QMemberMission;

import java.util.List;

@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Mission> findMissionsByMember(Long memberId, int limit, int offset) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QMemberMission memberMission = QMemberMission.memberMission;

        return queryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .join(memberMission).on(memberMission.mission.eq(mission))
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.in(
                                MissionStatus.CHALLENGING,
                                MissionStatus.COMPLETE
                        )
                )
                .orderBy(
                        new CaseBuilder()
                                .when(memberMission.status.eq(MissionStatus.CHALLENGING)).then(1)
                                .when(memberMission.status.eq(MissionStatus.COMPLETE)).then(2)
                                .otherwise(3)
                                .asc(),
                        memberMission.updatedAt.desc()
                )
                .offset(offset)
                .limit(limit)
                .fetch();
    }
}