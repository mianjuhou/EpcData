package com.potevio.msgsend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgSendService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void sendMsg(String msg) {
        redisTemplate.convertAndSend("terminal_status", msg);
    }

}
