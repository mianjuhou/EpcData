package com.potevio.hssdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HssdataApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(HssdataApplication.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

}
