package com.potevio.messagequeue.service;
import com.potevio.messagequeue.domain.UeDump;
import com.potevio.messagequeue.mapper.UeDumpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UeDumpService {

    @Autowired
    private UeDumpMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public String sendMsg() {
        redisTemplate.convertAndSend("topic", "Hello from Redis!");
        return "ok";
    }

    public String insert() {
        List<UeDump> list = new ArrayList<UeDump>();
        UeDump dump1 = new UeDump();
        dump1.setImsi("060000323404298");
        dump1.setAttachstatus(1);
        dump1.setUeipaddr("20.0.78.94");
        dump1.setUestatuschangetime(new Date());
        dump1.setUemacroenbid("9");
        dump1.setUecellid("16");
        dump1.setMmeappip("111.111.111.11");
        dump1.setRgwid("20");
        UeDump dump2 = new UeDump();
        dump2.setImsi("060000323404299");
        dump2.setAttachstatus(1);
        dump2.setUeipaddr("20.0.78.94");
        dump2.setUestatuschangetime(new Date());
        dump2.setUemacroenbid("9");
        dump2.setUecellid("16");
        dump2.setMmeappip("111.111.111.11");
        dump2.setRgwid("19");
        list.add(dump1);
        list.add(dump2);
        mapper.insertBatch(list);
        return "ok";
    }

}
