package com.newquality.app.member.application;

import com.newquality.app.member.dao.MemberRepository;
import com.newquality.app.member.domain.Member;
import com.newquality.app.member.dto.MemberRequest;
import com.newquality.app.member.dto.MemberResponse;
import com.newquality.app.member.exception.NotFoundDataException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse createMember(MemberRequest memberRequest) {
        Member saved = memberRepository.save(memberRequest.toMember());
        return MemberResponse.of(saved);
    }

    public MemberResponse findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundDataException::new);
        return MemberResponse.of(member);
    }
}
