package cn.sucre.dao.impl;


import cn.sucre.dao.ProvinceDao;
import cn.sucre.domain.Province;
import cn.sucre.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量 jdbctemplement
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //1.定义sql
        String sql = "select * from province ";
        //2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
