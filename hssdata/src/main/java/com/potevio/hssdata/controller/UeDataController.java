package com.potevio.hssdata.controller;

import com.potevio.hssdata.pojo.UeData;
import com.potevio.hssdata.service.UeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hss")
public class UeDataController {

    @Autowired
    private UeDataService service;

    /**
     * 查询单个imsi对应的数据
     * @param imsi
     * @return
     */
//    @GetMapping("/{imsi}")
//    public UeData findById(@PathVariable String imsi){
//        return service.findById(imsi);
//    }

    /**
     * 查询多个imsi对应的数据
     * @param datas
     * @return
     */
//    @PostMapping("/ids")
//    public List<UeData> findByIds(@RequestBody String[] datas){
//        return service.findByIds(datas);
//    }

    /**
     * 更新一条数据
     * @return
     */
//    @PostMapping("/update")
//    public int updateData(@RequestBody UeData ueData){
//        return service.updateData(ueData);
//    }

//    @GetMapping("/redis/{key}")
//    public String getRedis(@PathVariable String key){
//        return service.getValue(key);
//    }

//    @GetMapping("/getHash/{key}/{hashKey}")
//    public String getHash(@PathVariable String key,@PathVariable String hashKey){
//        return service.getHash(key,hashKey);
//    }
//
//    @GetMapping("/putHash/{key}/{hashKey}/{hashValue}")
//    public String putHash(@PathVariable String key,@PathVariable String hashKey,@PathVariable String hashValue){
//        return service.putHash(key,hashKey,hashValue);
//    }
//
//    @GetMapping("/putHashAll/{key}")
//    public String putHashAll(@PathVariable String key){
//        return service.putHashAll(key);
//    }
//
//    @GetMapping("/getHashAll/{key}")
//    public List<String> getHashAll(@PathVariable String key){
//        return service.getHashAll(key);
//    }

    @GetMapping("/syncData")
    public String syncData(){
        return service.selectData();
    }

}
