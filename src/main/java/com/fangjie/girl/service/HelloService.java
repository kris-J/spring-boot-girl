package com.fangjie.girl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HelloService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getTestData(){
        List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM test");
        for(Map<String, Object> each : result){
            System.out.println(each.get("num"));
        }
    }
}
