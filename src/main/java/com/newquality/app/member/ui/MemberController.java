package com.newquality.app.member.ui;

import com.newquality.app.member.application.MemberService;
import com.newquality.app.member.dto.MemberRequest;
import com.newquality.app.member.dto.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public ResponseEntity createMember(@RequestBody MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.createMember(memberRequest);
        return ResponseEntity.created(URI.create("/member/" + memberResponse.getId())).body(memberResponse);
    }

    @GetMapping(value = "/member/{id}")
    public ResponseEntity selectMember(@PathVariable Long id) {
        MemberResponse finded = memberService.findMember(id);
        return ResponseEntity.ok().body(finded);
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/member/{id}")
    public ResponseEntity updateMember(@PathVariable Long id,
                                       @RequestBody MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.updateMember(id, memberRequest);
        return ResponseEntity.ok(memberResponse);
    }
}
