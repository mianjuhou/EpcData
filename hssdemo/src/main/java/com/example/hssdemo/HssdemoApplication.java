package com.example.hssdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HssdemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(HssdemoApplication.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

}
