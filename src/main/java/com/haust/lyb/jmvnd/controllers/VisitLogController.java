package com.haust.lyb.jmvnd.controllers;

import com.haust.lyb.jmvnd.services.visitlog.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class VisitLogController {


    @Autowired
    VisitLogService visitLogService;


    @GetMapping("getVisitTimes")
    public HashMap getVisitTimes(){
        return visitLogService.getVisitTimes();
    }
}
