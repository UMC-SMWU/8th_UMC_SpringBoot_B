package umc.spring.repository.MemberRepository;

import umc.spring.web.dto.MyPageInfoDto;

public interface MemberRepositoryCustom {
    MyPageInfoDto findMyPageInfoById(Long memberId);
}