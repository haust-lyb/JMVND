package com.haust.lyb.jmvnd.daos;


import com.haust.lyb.jmvnd.entitys.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitLogDao extends JpaRepository<VisitLog,Long>, JpaSpecificationExecutor<VisitLog> {
}
