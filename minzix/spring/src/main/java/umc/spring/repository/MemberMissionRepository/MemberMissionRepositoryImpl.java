package umc.spring.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.dto.memberMission.MemberMissionDto;

import java.util.List;

@RequiredArgsConstructor
// 필수 어노테이션: 생성자를 자동으로 생성 (final 필드 포함)
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    // JPAQueryFactory는 QueryDSL 쿼리를 생성하고 실행하기 위한 핵심 객체입니다.
    // 생성자 주입 방식으로 주입되며, @Configuration 클래스나 Spring Bean 설정을 통해 주입됩니다.
    private final JPAQueryFactory queryFactory;

    /**
     * 사용자 미션 정보를 조회하는 메서드
     * @param userId    대상 사용자 ID
     * @param cursorId  커서 기반 페이지네이션을 위한 기준 ID (이 값보다 작은 ID만 조회)
     * @param pageSize  한 번에 가져올 데이터 수
     * @return          조건에 맞는 UserMissionDto 리스트
     */
    @Override
    public List<MemberMissionDto> findUserMissions(Long userId, Long cursorId, int pageSize) {
        // QueryDSL로 생성된 Q타입 객체 사용
        QMemberMission um = QMemberMission.memberMission;
        QMission m = QMission.mission;
        QStore s = QStore.store;

        // SELECT 절에서 DTO 생성자를 사용하여 필요한 필드를 매핑
        return queryFactory
                .select(Projections.constructor(MemberMissionDto.class,
                        um.id,                // user_mission의 id
                        um.missionStatus,            // user_mission의 상태 (예: 완료, 진행중 등)
                        m.reward,             // mission의 보상 정보
//                        m.missionContent,     // mission의 설명
                        s.name,               // store의 이름
                        um.createdAt          // user_mission의 생성 시각
                ))
                .from(um)                    // 메인 테이블은 user_mission
                .join(um.mission, m)         // user_mission.mission (FK)을 통해 mission 테이블과 JOIN
                .join(m.store, s)            // mission.store (FK)를 통해 store 테이블과 JOIN
                .where(
                        um.member.id.eq(userId),                    // 특정 사용자의 미션만 조회
                        cursorId == null ? null : um.id.lt(cursorId) // 커서 기반 페이징 조건
                )
                .orderBy(um.id.desc())       // 최신순 정렬
                .limit(pageSize)             // LIMIT 절
                .fetch();                    // 결과 리스트 반환
    }
}
