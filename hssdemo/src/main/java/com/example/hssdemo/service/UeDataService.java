package com.example.hssdemo.service;

import com.example.hssdemo.domain.UeData;
import com.example.hssdemo.mapper.UeDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UeDataService {

    @Autowired
    private UeDataMapper mapper;

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

    public List<UeData> selectUeData(int page, int size) {
        return mapper.selectUeData(page, size);
    }

    public String syncData() {
        HashOperations hash = redisTemplate.opsForHash();
        long count = mapper.count();
        System.out.println("总数量：" + count);
        long startTime = System.currentTimeMillis();
        Map<String, String> map = new HashMap();
        long i = 0;
        int PAGE = 2000;
        for (; i < count; i = i + PAGE) {
            List<UeData> ueDatas = mapper.selectUeData(i, PAGE);
            System.out.println("数量：" + i + ":" + ueDatas.size());
            ueDatas.forEach(ueData -> {
                map.clear();
                map.put("imsi", ueData.getImsi());
                map.put("mmeaddr", ueData.getMmeaddr());
                map.put("ispurged", String.valueOf(ueData.getIspurged()));
                map.put("ueambrul", String.valueOf(ueData.getUeambruL()));
                map.put("ueambrdl", String.valueOf(ueData.getUeambrdL()));
                map.put("homestationaddr", ueData.getHomestationaddr());
                map.put("homestationport", ueData.getHomestationport());
                map.put("serviceareaind", String.valueOf(ueData.getServiceareaind()));
                map.put("uerohcind", String.valueOf(ueData.getUerohcind()));
                map.put("freqind", String.valueOf(ueData.getFreqind()));
                map.put("algepc", String.valueOf(ueData.getAlgepc()));
                map.put("ueipaddr", ueData.getUeipaddr());
                map.put("qci", String.valueOf(ueData.getQci()));
                map.put("apnambrul", String.valueOf(ueData.getApnambrul()));
                map.put("apnambrdl", String.valueOf(ueData.getApnambrdl()));
                map.put("rgwidentity", String.valueOf(ueData.getRgwidentity()));
                map.put("pdntype", String.valueOf(ueData.getPdntype()));
                map.put("apn", ueData.getApn());
                hash.putAll(ueData.getImsi(), map);
            });
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总用时：" + (endTime - startTime) / 1000 + "s");
        return "ok";
    }

    public void changeDatabase(int db) {
        LettuceConnectionFactory factory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
        factory.setDatabase(db);
        redisTemplate.setConnectionFactory(factory);
    }

    public String getDb1() {
        changeDatabase(1);
        String value = (String) redisTemplate.opsForValue().get("name");
        return value;
    }

    public void getAll() {
        HashOperations hash = redisTemplate.opsForHash();
        Set<String> keys = redisTemplate.keys("*");
        Set<String> mkeys = new HashSet<>();
        mkeys.add("name");
        mkeys.add("gender");
        mkeys.add("major");
        for (String key : keys) {
            List<String> mvalues = hash.multiGet(key, mkeys);
            System.out.println(mvalues);
        }
//        System.out.println(keys);
//        redisTemplate.l
    }

    public void sendMsg() {
        redisTemplate.convertAndSend("", "");
    }

}
