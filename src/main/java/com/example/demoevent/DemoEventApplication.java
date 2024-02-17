package com.example.demoevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * https://wildeveloperetrain.tistory.com/217
 * https://velog.io/@shinmj1207/Apache-Kafka-Docker-%ED%99%98%EA%B2%BD%EC%97%90%EC%84%9C-Spring-boot-Kafka-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0
 */
@EnableAsync
@SpringBootApplication
public class DemoEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEventApplication.class, args);
    }

}
