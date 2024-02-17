package com.example.demoevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * https://wildeveloperetrain.tistory.com/217
 */
@EnableAsync
@SpringBootApplication
public class DemoEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEventApplication.class, args);
    }

}
