package umc.nnmrm.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.nnmrm.domain.QMission;
import umc.nnmrm.domain.QStore;
import umc.nnmrm.domain.enums.MissionStatus;
import umc.nnmrm.domain.mapping.QMemberMission;
import umc.nnmrm.dto.MemberMissionResponseDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMissionResponseDto> findMemberMissionsWithPaging(Long memberId, String cursorId, int limit) {
        QMemberMission mm = QMemberMission.memberMission;
        QMission m = QMission.mission;
        QStore s = QStore.store;

        return queryFactory
                .select(Projections.constructor(MemberMissionResponseDto.class,
                        mm.id,
                        mm.status.stringValue(),
                        mm.createdAt,
                        m.id,
                        m.reward,
                        m.missionSpec,
                        s.name,
                        Expressions.constant("") // 임시로 빈 값 넣기
                ))
                .from(mm)
                .join(mm.mission, m)
                .join(m.store, s)
                .where(
                        mm.member.id.eq(memberId),
                        mm.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETE),
                        cursorId == null ? null : mm.id.lt(Long.valueOf(cursorId))
                )
                .orderBy(mm.id.desc())
                .limit(limit)
                .fetch();
    }
}