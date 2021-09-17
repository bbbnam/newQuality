package com.newquality.app.member.application;

import com.newquality.app.member.domain.MemberRepository;
import com.newquality.app.member.domain.Member;
import com.newquality.app.member.dto.MemberRequest;
import com.newquality.app.member.dto.MemberResponse;
import com.newquality.app.member.exception.NotFoundDataException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
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

    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundDataException::new);
        member.delete();
    }

    public MemberResponse updateMember(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundDataException::new);
        member.update(memberRequest.toMember());
        return MemberResponse.of(member);
    }
}
