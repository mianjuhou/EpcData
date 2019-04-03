package com.potevio.fromredis.service;

import com.potevio.fromredis.domain.UeDump;
import com.potevio.fromredis.mapper.UeDumpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduledService {
    @Autowired
    private UeDumpMapper dumpMapper;

    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() {
        long startTime = System.currentTimeMillis();
        HashOperations hash = redisTemplate.opsForHash();
        Set<String> keys = redisTemplate.keys("*");
        List<String> mkeys = new ArrayList<>();
        mkeys.add("imsi");
        mkeys.add("attachstatus");
        mkeys.add("ueipaddr");
        mkeys.add("uestatuschangetime");
        mkeys.add("uemacroenbid");
        mkeys.add("uecellid");
        mkeys.add("mmeappip");
        mkeys.add("rgwid");
        List<UeDump> dumps = new ArrayList<>();
        for (String key : keys) {
            List<String> mvalues = hash.multiGet(key, mkeys);
            redisTemplate.delete(key);
            UeDump dump = new UeDump();
            dump.setImsi(mvalues.get(0));
            dump.setAttachstatus(Integer.valueOf(mvalues.get(1)));
            dump.setUeipaddr(mvalues.get(2));
            dump.setUestatuschangetime(new Date());
            dump.setUemacroenbid(Integer.valueOf(mvalues.get(4)));
            dump.setUecellid(Integer.valueOf(mvalues.get(5)));
            dump.setMmeappip(mvalues.get(6));
            dump.setRgwid(Integer.valueOf(mvalues.get(7)));
            dumps.add(dump);
            if (dumps.size() >= 1000) {
                System.out.println("插入数量：" + dumps.size());
                dumpMapper.insertBatch(dumps);
                dumps.clear();
            }
        }
        if (dumps.size() > 0) {
            System.out.println("插入数量：" + dumps.size());
            dumpMapper.insertBatch(dumps);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("插入总用时：" + (endTime - startTime) / 1000 + "s");
    }

}
