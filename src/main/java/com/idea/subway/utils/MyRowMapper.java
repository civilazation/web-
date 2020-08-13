package com.idea.subway.utils;

import com.idea.subway.entity.Subway;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 映射实体和数据库表
 */
public class MyRowMapper implements RowMapper<Subway> {
    @Override
    public Subway mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String stationName = resultSet.getString("stationName");
        double distance = resultSet.getDouble("distance");
        int time_between_stations = resultSet.getInt("time_between_stations");
        Subway subway = new Subway();
        subway.setId(id);
        subway.setStationName(stationName);
        subway.setDistance(distance);
        subway.setTimeBetweenStations(time_between_stations);
        return subway;
    }
}
