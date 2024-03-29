package com.example.demoevent.controller;

import com.example.demoevent.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{productName}")
    private void order(@PathVariable String productName) {
        orderService.order(productName);
        log.info("1. 주문이 완료되었습니다.");
    }

    @GetMapping("/order2/{productName}")
    private void order2(@PathVariable String productName) {
        orderService.order2(productName);
        log.info("2. 주문이 완료되었습니다.");
    }
}
