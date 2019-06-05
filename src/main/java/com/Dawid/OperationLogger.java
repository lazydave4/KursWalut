package com.Dawid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PostConstruct;

    @Component
    public class OperationLogger {

        @Autowired
        JdbcTemplate jdbcTemplate;


     public void log(OperationData operationData){
            jdbcTemplate.execute("INSERT INTO Operation_Data(operation,amount,result) VALUES ('"+operationData.getOperation()+"','"+operationData.getAmount()+"','"+operationData.getResult()+"')");

        }

        @PostConstruct
        private void createTable(){
            jdbcTemplate.execute("CREATE TABLE Operation_Data(operation VARCHAR(255),amount VARCHAR(255),result VARCHAR(255))");

        }


    }



