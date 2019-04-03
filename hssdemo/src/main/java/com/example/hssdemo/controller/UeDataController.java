package com.example.hssdemo.controller;

import com.example.hssdemo.domain.UeData;
import com.example.hssdemo.mapper.UeDataMapper;
import com.example.hssdemo.service.UeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hss")
public class UeDataController {

    @Autowired
    private UeDataService service;

    @RequestMapping("/find/{page}/{size}")
    public List<UeData> selectUeData(@PathVariable("page") int page, @PathVariable("size") int size) {
        return service.selectUeData(page, size);
    }

    @RequestMapping("/syncData")
    public String syncData() {
        service.syncData();
        return "ok";
    }

    @RequestMapping("/changeDB")
    public String changeDB() {
        return service.getDb1();
    }

    @RequestMapping("/getall")
    public String getAll() {
        service.getAll();
        return "ok";
    }
}
