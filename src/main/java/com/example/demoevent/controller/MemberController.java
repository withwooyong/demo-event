package com.example.demoevent.controller;

import com.example.demoevent.dto.MemberDto;
import com.example.demoevent.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public void signUp(@Param("id") Long id,
                       @Param("name") String name) {
        memberService.signUp(new MemberDto(id, name));
    }
}