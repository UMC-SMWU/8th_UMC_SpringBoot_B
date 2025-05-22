package umc.spring.repository.MemberRepository;

import umc.spring.dto.Member.MemberInfoDto;

public interface MemberRepositoryCustom {
    MemberInfoDto findUserInfoById(Long userId);
}