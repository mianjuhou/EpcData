package com.potevio.hssdata.dao;

import com.potevio.hssdata.pojo.SubData;
import com.potevio.hssdata.pojo.UeData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UeDataDao extends JpaRepository<SubData, String> {
//    //    @Transactional
//    @Query(value = "update UeData set mmeaddr = :addr,ispurged = :isp where imei = :id")
//    int update(@Param("addr") String mmeaddr, @Param("isp") int ispurged, @Param("id") String imei);
//
//    @Query(value = "update tuedata set mmeaddr = ? ,", nativeQuery = true)
//    int updateByAddr();

//    @Query(value = "select homestationaddr,homestationport,serviceareaind,uerohcind,freqind,algepc,ueipaddr,qci,apnambrul,apnambrdl,rgwidentity,pdntype,apn,mmeaddr,ispurged,ueambrul,ueambrdl,a.imsi from tuedata a,tsubcontext b where a.Imsi=b.Imsi", nativeQuery = true)
//    Page<Object> selectData(Pageable pageable);

    @Query(value = "select mmeaddr,ispurged,ueambrul,ueambrdl,imsi from tuedata as a", nativeQuery = true)
    Page<Object> selectData(Pageable pageable);

}
