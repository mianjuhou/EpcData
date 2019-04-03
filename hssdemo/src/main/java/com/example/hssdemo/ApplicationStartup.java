package com.example.hssdemo;

import com.example.hssdemo.service.UeDataService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        UeDataService service = contextRefreshedEvent.getApplicationContext().getBean(UeDataService.class);
        service.syncData();
    }
}
