package com.potevio.hssdata.service;

import com.potevio.hssdata.dao.UeDataDao;
import com.potevio.hssdata.pojo.UeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UeDataService {
    @Autowired
    private UeDataDao dao;

    private RedisTemplate redisTemplate;

//    @Autowired(required = false)
//    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
////        redisTemplate.setHashKeySerializer(stringSerializer);
////        redisTemplate.setHashValueSerializer(stringSerializer);
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Autowired(required = false)
//    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//        this.redisTemplate = redisTemplate;
//    }
//
//
//    public UeData findById(String id) {
//        if (redisTemplate.hasKey(id)) {
//            return findByIdRedis(id);
//        } else {
//            UeData ueData = dao.findById(id).get();
//            putByIdRedis(ueData);
//            return ueData;
//        }
//    }
//
//    public UeData findByIdRedis(String id) {
//        List<String> keys = new ArrayList<>();
//        keys.add("imsi");
//        keys.add("mmeaddr");
//        keys.add("ispurged");
//        keys.add("ueambrul");
//        keys.add("ueambrdl");
//        HashOperations hash = redisTemplate.opsForHash();
//        List<String> values = hash.multiGet(id, keys);
//        UeData ueData = new UeData();
//        ueData.setImsi(values.get(0));
//        ueData.setMmeaddr(values.get(1));
//        ueData.setIspurged(Integer.valueOf(values.get(2)));
//        ueData.setUeambruL(Integer.valueOf(values.get(3)));
//        ueData.setUeambrdL(Integer.valueOf(values.get(4)));
//        return ueData;
//    }
//
//    public void putByIdRedis(UeData ueData) {
//        Map<String, String> map = new HashMap();
//        map.put("imsi", ueData.getImsi());
//        map.put("mmeaddr", ueData.getMmeaddr());
//        map.put("ispurged", String.valueOf(ueData.getIspurged()));
//        map.put("ueambrul", String.valueOf(ueData.getUeambruL()));
//        map.put("ueambrdl", String.valueOf(ueData.getUeambrdL()));
//        HashOperations hash = redisTemplate.opsForHash();
//        hash.putAll(ueData.getImsi(), map);
//    }
//
//    public List<UeData> findByIds(String[] ids) {
//        List<UeData> ueDatas = new ArrayList<>();
//        List<String> sqlIds = new ArrayList<>();
//        for (int i = 0; i < ids.length; i++) {
//            String id = ids[i];
//            if (redisTemplate.hasKey(id)) {
//                ueDatas.add(findByIdRedis(id));
//            } else {
//                sqlIds.add(id);
//            }
//        }
//        List<UeData> all = dao.findAllById(sqlIds);
//        //新启一个线程执行
//        all.forEach(ueData -> {
//            putByIdRedis(ueData);
//        });
//        ueDatas.addAll(all);
//        return ueDatas;
//    }
//
//    public int updateData(UeData ueData) {
//        redisTemplate.delete(ueData.getImsi());
//        int updateNum = dao.update(ueData.getMmeaddr(), ueData.getIspurged(), ueData.getImsi());
//        return updateNum;
//    }
//
//    public String getValue(String key) {
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//        String value = ops.get(key);
//        return value;
//    }
//
//    public String getHash(String key, String hashKey) {
//        HashOperations hash = redisTemplate.opsForHash();
//        String value = (String) hash.get(key, hashKey);
//        return value;
//    }
//
//    public String putHash(String key, String hashKey, String value) {
//        HashOperations hash = redisTemplate.opsForHash();
//        hash.put(key, hashKey, value);
//        return "ok";
//    }
//
//    public String putHashAll(String key) {
//        Map<String, String> map = new HashMap();
//        map.put("mmeaddr", "lkh");
//        map.put("ispurged", "17");
//        map.put("ueambrul", "w");
//        map.put("ueambrdl", "w");
//        HashOperations hash = redisTemplate.opsForHash();
//        hash.putAll(key, map);
//        return "ok";
//    }
//
//    public List<String> getHashAll(String key) {
//        List<String> keys = new ArrayList<>();
//        keys.add("mmeaddr");
//        keys.add("ispurged");
//        keys.add("ueambrul");
//        keys.add("ueambrdl");
//        HashOperations hash = redisTemplate.opsForHash();
//        List<String> values = hash.multiGet(key, keys);
//        return values;
//    }
//
//    public String syncData() {
//        HashOperations hash = redisTemplate.opsForHash();
//        long count = dao.count();
//        System.out.println("总数量：" + count);
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i <= (count / 1000); i++) {
//            PageRequest pageRequest = PageRequest.of(i, 1000);
//            Page<UeData> page = dao.findAll(pageRequest);
//            page.forEach(ueData -> {
//                Map<String, String> map = new HashMap();
//                map.put("imsi", ueData.getImsi());
//                map.put("mmeaddr", ueData.getMmeaddr());
//                map.put("ispurged", String.valueOf(ueData.getIspurged()));
//                map.put("ueambrul", String.valueOf(ueData.getUeambruL()));
//                map.put("ueambrdl", String.valueOf(ueData.getUeambrdL()));
//                hash.putAll(ueData.getImsi(), map);
//            });
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("总用时：" + (endTime - startTime) / 1000 + "s");
//        return "ok";
//    }
//
//    public String syncData2() {
//        ValueOperations ops = redisTemplate.opsForValue();
//        long count = dao.count();
//        System.out.println("总数量：" + count);
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i <= (count / 1000); i++) {
//            PageRequest pageRequest = PageRequest.of(i, 1000);
//            Page<UeData> page = dao.findAll(pageRequest);
//            page.forEach(ueData -> {
//                ops.set(ueData.getImsi(), ueData);
//            });
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("总用时：" + (endTime - startTime) / 1000 + "s");
//        return "ok";
//    }
//
    public void insertBetch(){
//        dao.saveAll()
    }

    public String selectData() {
        PageRequest pageRequest = PageRequest.of(0, 1000);
        Page<Object> ueData = dao.selectData(pageRequest);
        System.out.println("数量" + ueData.getTotalElements());
        return "ok";
    }




}
