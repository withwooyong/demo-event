package com.example.demoevent.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "ted-topic1", groupId = "ted-group")
    public void consume(String message) {
        log.info("Consumed message : {}", message);
    }
}
