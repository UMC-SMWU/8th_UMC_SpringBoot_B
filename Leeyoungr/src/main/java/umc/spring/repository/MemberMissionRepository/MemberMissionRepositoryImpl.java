package umc.spring.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.web.dto.MemberMissionDto;
import static com.querydsl.core.types.Projections.constructor;

import java.util.List;

import static umc.spring.domain.QMission.mission;
import static umc.spring.domain.QStore.store;
import static umc.spring.domain.mapping.QMemberMission.memberMission;

@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMissionDto> findMemberMissions(Long memberId, Long cursorId, int limit) {
        return queryFactory
                .select(constructor(
                        MemberMissionDto.class,
                        memberMission.id,
                        memberMission.status,
                        mission.reward,
                        mission.missionSpec,
                        store.name
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .where(
                        memberMission.member.id.eq(memberId),
                        cursorId != null ? memberMission.id.lt(cursorId) : null
                )
                .orderBy(memberMission.id.desc())
                .limit(limit)
                .fetch();
    }
}
