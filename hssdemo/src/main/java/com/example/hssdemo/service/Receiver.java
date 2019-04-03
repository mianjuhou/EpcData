package com.example.hssdemo.service;

import com.example.hssdemo.domain.UeDump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Receiver implements MessageListener {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private KryoRedisSerializer<UeDump> serializer;

    public Receiver() {
        serializer = new KryoRedisSerializer<>(UeDump.class);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        UeDump ueDump = serializer.deserialize(message.getBody());

    }
}
