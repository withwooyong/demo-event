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
        log.info("주문이 완료되었습니다.");
    }
}
