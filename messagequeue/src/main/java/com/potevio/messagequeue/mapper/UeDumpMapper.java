package com.potevio.messagequeue.mapper;

import com.potevio.messagequeue.domain.UeDump;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UeDumpMapper {

    void insertBatch(List<UeDump> list);

    List<UeDump> getAll();
}
