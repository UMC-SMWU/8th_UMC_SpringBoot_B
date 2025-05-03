package umc.nnmrm.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.nnmrm.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
