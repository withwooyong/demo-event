package com.example.demoevent.controller;

import com.example.demoevent.dto.MemberDto;
import com.example.demoevent.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp/{id}/{name}")
    public void signUp(@PathVariable Long id,
                       @PathVariable String name) {
        memberService.signUp(new MemberDto(id, name));
    }
}