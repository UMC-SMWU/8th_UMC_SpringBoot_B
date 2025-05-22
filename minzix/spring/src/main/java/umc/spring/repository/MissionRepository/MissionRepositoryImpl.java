package umc.spring.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.dto.MissionList.MissionListDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MissionListDto> findMissionByRegion(String regionName, Long cursorId, int pageSize) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        List<MissionListDto> results = queryFactory
                .select(
                        com.querydsl.core.types.Projections.constructor(MissionListDto.class,
                                store.name,
                                mission.deadline,
                                mission.missionSpec,
                                mission.reward,
                                mission.id
                        )
                )
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        region.name.eq(regionName),
                        mission.deadline.goe(LocalDate.now()),
                        cursorId != null ? mission.id.lt(cursorId) : null
                )
                .orderBy(mission.id.desc())
                .limit(pageSize)
                .fetch()
                .stream()
                .peek(dto -> System.out.println("MissionListDto: " + dto))
                .collect(Collectors.toList());

        System.out.println("결과 개수: " + results.size());
        return results;
    }
}
