package com.potevio.toredis.service;

import com.potevio.toredis.dao.UeDumpDao;
import com.potevio.toredis.pojo.UeDump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UeDumpService {

    @Autowired
    private UeDumpDao dao;

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

    private int page = -1;
    private int size = 1000;

    public String insertIntoRedis() {
        page++;
        Page<UeDump> dumps = dao.findAll(PageRequest.of(page, size));
        Map<String, String> map = new HashMap<>();
        dumps.forEach(dump -> {
            map.put("imsi", dump.getImsi());
            map.put("attachstatus", String.valueOf(dump.getAttachstatus()));
            map.put("ueipaddr", dump.getUeipaddr());
            map.put("uestatuschangetime", dump.getUestatuschangetime().toString());
            map.put("uemacroenbid", dump.getUemacroenbid() + "");
            map.put("uecellid", dump.getUecellid() + "");
            map.put("mmeappip", dump.getMmeappip() + "");
            map.put("rgwid", dump.getRgwid() + "");
            redisTemplate.opsForHash().putAll(dump.getImsi(), map);
        });
        if (dumps.getNumberOfElements() < size) {
            page = -1;
        }
        return dumps.getNumberOfElements() + "";
    }

}
