package com.newquality.app.member.ui;

import com.newquality.app.member.application.MemberService;
import com.newquality.app.member.dto.MemberRequest;
import com.newquality.app.member.dto.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public ResponseEntity createMember(MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.createMember(memberRequest);
        return ResponseEntity.created(URI.create("/member/" + memberResponse.getId())).build();
    }
}
