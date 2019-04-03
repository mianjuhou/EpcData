package com.potevio.toredis.dao;

import com.potevio.toredis.pojo.UeDump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UeDumpDao extends JpaRepository<UeDump, String>, JpaSpecificationExecutor<UeDump> {
}
