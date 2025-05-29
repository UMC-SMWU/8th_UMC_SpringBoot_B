package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    default Member getMemberOrThrow(Long memberId) {
        return findById(memberId).orElseThrow(() ->
            new IllegalArgumentException("해당 ID의 멤버를 찾을 수 없습니다: " + memberId));
    }
}