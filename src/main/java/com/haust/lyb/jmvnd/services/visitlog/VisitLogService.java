package com.haust.lyb.jmvnd.services.visitlog;

import java.util.HashMap;

public interface VisitLogService {

    HashMap getVisitTimes();

    HashMap addVisit(String message);

    HashMap getVisitLog();
}
