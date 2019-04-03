package com.potevio.fromredis.mapper;

import com.potevio.fromredis.domain.UeDump;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UeDumpMapper {
    void insertBatch(List<UeDump> list);
}
