package com.example.demoevent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MailService {

    public void sendMail(String productName) {
        log.info(String.format("메일 발송 [상품명 : %s]", productName));
    }
}
