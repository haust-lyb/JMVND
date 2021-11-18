package com.haust.lyb.jmvnd.services.visitlog;

import com.haust.lyb.jmvnd.daos.VisitLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    @Autowired
    VisitLogDao visitLogDao;

    @Override
    public HashMap getVisitTimes() {
        HashMap<String, Object> rs = new HashMap<>();
        rs.put("code","200");
        rs.put("message",visitLogDao.count());
        rs.put("log","v1.3");
        return rs;
    }
}
