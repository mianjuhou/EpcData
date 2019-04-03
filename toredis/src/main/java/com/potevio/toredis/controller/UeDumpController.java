package com.potevio.toredis.controller;

import com.potevio.toredis.service.UeDumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toredis")
public class UeDumpController {

    @Autowired
    private UeDumpService dumpService;

    @RequestMapping("/insert")
    public String insertIntoRedis() {
        String num = dumpService.insertIntoRedis();
        return "ok:" + num;
    }

}
