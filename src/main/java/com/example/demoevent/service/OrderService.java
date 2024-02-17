package com.example.demoevent.service;

import com.example.demoevent.event.OrderedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ApplicationEventPublisher publisher;
    private final PushService pushService;
    private final MailService mailService;

    public void order(String productName) {
        //주문 처리
        log.info(String.format("주문 로직 처리 [상품명 : %s]", productName));
        publisher.publishEvent(new OrderedEvent(productName));
    }

    public void order2(String productName) {
        //주문 처리
        log.info(String.format("주문 로직 처리 [상품명 : %s]", productName));
        pushService.sendPush(productName);
        mailService.sendMail(productName);
    }
}