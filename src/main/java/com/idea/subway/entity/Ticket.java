package com.idea.subway.entity;

import java.util.List;

public class Ticket {
    private String startStationName;
    private String endStationName;
    private Integer stationNum;
    private double distance;
    private Integer time;
    private String arrivalTime;
    private double price;
    private List<String> list;

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public Integer getStationNum() {
        return stationNum;
    }

    public void setStationNum(Integer stationNum) {
        this.stationNum = stationNum;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "startStationName='" + startStationName + '\'' +
                ", endStationName='" + endStationName + '\'' +
                ", stationNum=" + stationNum +
                ", distance=" + distance +
                ", time=" + time +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                ", list=" + list +
                '}';
    }
}
