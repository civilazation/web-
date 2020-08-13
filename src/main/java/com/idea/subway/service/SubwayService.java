package com.idea.subway.service;

import com.idea.subway.entity.Ticket;

import java.util.List;
import java.util.Map;

public interface SubwayService {
    //查询所有的站点名称
    List<Map<String,Object>> getAllStationName();
    //查询两站之间的信息
    Ticket getBetweenTwoStationAll(Integer startId, Integer endId);
}

