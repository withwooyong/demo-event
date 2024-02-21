package com.example.demoevent.service;

import com.example.demoevent.dto.MemberDto;
import com.example.demoevent.event.MemberEvent;
import com.example.demoevent.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberService {

    //회원가입, 중복되었을 때?
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void signUp(MemberDto memberDto) {
        log.info("before publishEvent() method.");
        eventPublisher.publishEvent(new MemberEvent(memberDto));
        log.info("after publishEvent() method.");

        if (memberDto.getName().equals("master")) {
            throw new RuntimeException("can not use this name.");
        }
    }
}
