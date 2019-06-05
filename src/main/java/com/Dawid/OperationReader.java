package com.Dawid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationReader {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OperationData> getOperationList(){
        return  jdbcTemplate.query("SELECT operation,amount,result FROM Operation_Data",
                (rs, rowNum) -> new OperationData(rs.getString("operation"), rs.getString("amount"),rs.getString("result")));

    }
}