package com.idea.subway.service.impl;

import com.idea.subway.dao.SubwayDao;
import com.idea.subway.entity.Subway;
import com.idea.subway.entity.Ticket;
import com.idea.subway.service.SubwayService;
import com.idea.subway.utils.AccountPriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SubwayServiceImpl implements SubwayService {
    @Autowired
    private SubwayDao subwayDao;
    //查询所有站点名称
    @Override
    public List<Map<String, Object>> getAllStationName() {
        return subwayDao.getAllStationName();
    }
    //查询起始站点之间的信息
    @Override
    public Ticket getBetweenTwoStationAll(Integer startId, Integer endId) {
        //两站点的实际距离
        double distance = 0.0;
        //两站点的实际时间
        int time = 0;
        int tt = 0;
        boolean b = false;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try{
            Date date = new Date();
            String strDate = sdf.format(date);
            Date startTime = sdf.parse("06:30:00");
            Date endTime = sdf.parse("22:00:00");
            b = new AccountPriceUtil().belongCalendar(sdf.parse(strDate), startTime, endTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        //用来放两站点之间的站点名称
        List<String> list = new ArrayList<>();


        //查询两站点的信息
        List<Subway> betweenTwoStationList = subwayDao.getBetweenTwoStationAll(startId, endId);
        for (int i = 0; i < betweenTwoStationList.size(); i++) {
            //所经过站的名称放入另外一个集合
            list.add(betweenTwoStationList.get(i).getStationName());
            //计算两站点之间的距离
            distance += betweenTwoStationList.get(i).getDistance();
            //计算两站点时间
            time += betweenTwoStationList.get(i).getTimeBetweenStations();
        }
        //反向
        if(startId > endId && b==true){
            //计算实际起点和终点的时间
            time = time - betweenTwoStationList.get(betweenTwoStationList.size()-1).getTimeBetweenStations();
            //计算实际起点和终点的距离
            distance = distance - betweenTwoStationList.get(betweenTwoStationList.size()-1).getDistance();
        }else if(startId < endId && b==true){
            //反向，计算两站点实际时间
            time = time - betweenTwoStationList.get(0).getTimeBetweenStations();
            //计算两站点实际距离
            distance = distance - betweenTwoStationList.get(0).getDistance();
        }
        //将站点距离换算成公里
        distance = distance / 1000;
        //计算票价
        double price = new AccountPriceUtil().accountPrice(distance);
        //将距离保留两位小数
        BigDecimal km1 = new BigDecimal(distance);
        distance = km1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        List<Subway> startStationAndEndStationTime = subwayDao.getStartStationAndEndStationTime(startId, endId);
        for (int i = 0; i < startStationAndEndStationTime.size(); i++) {
            tt += startStationAndEndStationTime.get(i).getTimeBetweenStations();
        }
        String arrivalTime= new AccountPriceUtil().cal(tt);

        Ticket ticket = new Ticket();
        ticket.setStartStationName(list.get(0));
        ticket.setStartStationName(list.get(list.size()-1));
        ticket.setArrivalTime(arrivalTime);
        ticket.setStationNum(betweenTwoStationList.size());
        ticket.setDistance(distance);
        ticket.setTime(time);
        ticket.setPrice(price);
        ticket.setList(list);

        return ticket;
    }
}
