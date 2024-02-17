package com.example.demoevent.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://9hyuk9.tistory.com/92
 * https://velog.io/@shinmj1207/Apache-Kafka-Docker-%ED%99%98%EA%B2%BD%EC%97%90%EC%84%9C-Spring-boot-Kafka-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0
 */
@Log4j2
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    /**
     * docker-compose -f kafka-compose.yml up
     * docker ps
     * docker exec -it kafka /bin/bash
     * kafka-topics.sh --create --topic ted-topic1 --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3
     * <p>
     * 토픽 리스트 확인: kafka-topics.sh --list --bootstrap-server localhost:9092
     * 토픽 상세 조회: kafka-topics.sh --describe --topic ted-topic1 --bootstrap-server kafka:9092
     * 토픽 삭제: kafka-topics.sh --delete --bootstrap-server kafka:9092 --topic ted-topic1
     * <p>
     * sub: ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ted-topic1 --from-beginning
     * pub: ./kafka-console-producer.sh --topic ted-topic1 --broker-list kafka:9092
     */
//    @PostMapping("/send")
    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        log.info("before sendMessage() method.");
        producer.sendMessage(message);
        log.info("after sendMessage() method.");
        return message;
    }
}
