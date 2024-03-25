package com.drathing.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean 
    public DataSource dataSource(){
      
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/keyword");
        dataSource.setUsername("abc1234");
        dataSource.setPassword("Password1!");


        dataSource.setMaxTotal(13);
        dataSource.setMaxIdle(13); 
        return dataSource;
    }
    
    @Bean 
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
}
