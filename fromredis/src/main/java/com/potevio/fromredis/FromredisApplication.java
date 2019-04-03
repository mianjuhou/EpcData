package com.potevio.fromredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FromredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(FromredisApplication.class, args);
    }

}
