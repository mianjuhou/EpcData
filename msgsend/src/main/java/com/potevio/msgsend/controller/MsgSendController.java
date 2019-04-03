package com.potevio.msgsend.controller;

import com.potevio.msgsend.service.MsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msgsend")
public class MsgSendController {

    @Autowired
    private MsgSendService service;

    @RequestMapping("/send/{msg}")
    public String sendMsg(@PathVariable String msg) {
        service.sendMsg(msg);
        return "ok";
    }

}
