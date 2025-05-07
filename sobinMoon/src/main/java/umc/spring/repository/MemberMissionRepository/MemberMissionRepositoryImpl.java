package umc.spring.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MemberMissionStatus;
import umc.spring.web.dto.MemberMissionDto;

import static umc.spring.domain.QMember.member;
import static umc.spring.domain.mapping.QMemberMission.memberMission;
import static umc.spring.domain.QMission.mission;
import static umc.spring.domain.QStore.store;

import java.util.List;

import static com.querydsl.core.types.Projections.constructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MemberMissionDto> findMemberMission(Long memberId, Long cursorId, MemberMissionStatus missionStatus, int limit) {
        return jpaQueryFactory
                .select(constructor(
                        MemberMissionDto.class,
                        memberMission.id,
                        memberMission.status,
                        mission.reward,
                        mission.missionSpec,
                        store.name
                ))
                .from(memberMission)
                .join(memberMission.member, member)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .where(
                        member.id.eq(memberId),
                        memberMission.status.eq(missionStatus),
                        mission.id.lt(cursorId)
                )
                .orderBy(mission.id.desc())
                .limit(limit)
                .fetch();
    }
}
