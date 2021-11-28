package com.haust.lyb.jmvnd.services.visitlog;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.haust.lyb.jmvnd.daos.VisitLogDao;
import com.haust.lyb.jmvnd.entitys.VisitLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    @Autowired
    VisitLogDao visitLogDao;

    @Override
    public HashMap getVisitTimes() {
        HashMap<String, Object> rs = new HashMap<>();
        rs.put("code","200");
        rs.put("data",visitLogDao.count());
        return rs;
    }

    @Override
    public HashMap addVisit(String message) {
        VisitLog visitLog = new VisitLog();
        visitLog.setCreateTime(new Date());
        visitLog.setMsg(message);
        visitLogDao.save(visitLog);
        HashMap<String, Object> rs = new HashMap<>();
        rs.put("code","200");
        rs.put("message","success");
        return rs;
    }

    @Override
    public HashMap getVisitLog() {
        List<VisitLog> all = visitLogDao.findAll();
        List<HashMap<Object, Object>> data = all.stream().map(e -> {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("msg", e.getMsg());
            map.put("datetime", DateUtil.format(e.getCreateTime(), DatePattern.CHINESE_DATE_FORMAT));
            map.put("id", e.getId());
            return map;
        }).collect(Collectors.toList());

        HashMap<String, Object> rs = new HashMap<>();
        rs.put("code","200");
        rs.put("message","success");
        rs.put("data",data);
        return rs;
    }
}
