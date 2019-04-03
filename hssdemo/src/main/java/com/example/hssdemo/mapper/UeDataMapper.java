package com.example.hssdemo.mapper;

import com.example.hssdemo.domain.UeData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UeDataMapper {

    List<UeData> selectUeData(@Param("page") long page, @Param("size") int size);

    long count();


}
