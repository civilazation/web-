package com.idea.subway.entity;

public class Subway {
    private Integer id;
    private String stationName;
    private double distance;
    private Integer timeBetweenStations;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Integer getTimeBetweenStations() {
        return timeBetweenStations;
    }

    public void setTimeBetweenStations(Integer timeBetweenStations) {
        this.timeBetweenStations = timeBetweenStations;
    }
}
