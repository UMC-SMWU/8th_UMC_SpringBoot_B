package umc.spring.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.dto.Member.MemberRequestDTO;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom{
    Member joinMember(MemberRequestDTO.JoinDto request);
}
