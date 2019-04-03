package com.potevio.messagequeue.controller;

import com.potevio.messagequeue.service.UeDumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uedump")
public class UeDumpController {

    @Autowired
    private UeDumpService service;

    @RequestMapping("/insert")
    public String insert(){
        service.insert();
        return "ok";
    }

    @RequestMapping("/sendMsg")
    public String sendMsg(){
        service.sendMsg();
        return "ok";
    }

}
