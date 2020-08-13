package com.idea.subway.dao;
import com.idea.subway.entity.Subway;
import com.idea.subway.entity.User;
import com.idea.subway.utils.MyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public class SubwayDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    /**
     * @description 查询所有的站点名称
     * @return List<Map<String,Object>>
     */
    public List<Map<String,Object>> getAllStationName() {
        String sql = "select id,stationName from t_subway";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
    /**
     * @description 查询两个站点之间的信息,
     * @param startId
     * @param endId
     * @return List<Subway>
     */
    public List<Subway> getBetweenTwoStationAll(Integer startId, Integer endId) {
        //查询两个站点之间的信息,正向
        if (startId > endId){
            String sqlA = "select * from t_subway where  id between ?  and ? order by id desc ";
            return jdbcTemplate.query(sqlA, new MyRowMapper(),endId,startId);
            //查询两个站点之间的信息,反向
        }else {
            String sqlB = "select * from t_subway where  id between ?  and ?";
            return  jdbcTemplate.query(sqlB, new MyRowMapper(),startId,endId);
        }
    }
    /**
     * @description 查询第一个站点到起点站的时间
     * @param startId
     * @param endId
     * @return List<Subway>
     */
    public List<Subway> getStartStationAndEndStationTime(Integer startId,Integer endId){
        System.out.println(startId+"====");
        String sql = "select * from t_subway where  id between ";
        if(startId > endId){
            String sqlS = sql +" ?"+" and "+19;
            return jdbcTemplate.query(sqlS,new MyRowMapper(),endId+1);
        }else{
            String sqlE = sql + 1 + " and "+" ?";
            return jdbcTemplate.query(sqlE,new MyRowMapper(),startId);
        }
    }
    @Transactional
    public void save(User u){
      String sql="insert into t_user(name,age) values(:name,:age)";
        BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(u);
        namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }

}
