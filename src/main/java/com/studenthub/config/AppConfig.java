package com.studenthub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;

import org.h2.tools.Server;


@Configuration
@ComponentScan(value = "com.studenthub")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${db.url}")
    private String dbUrl;
    
    @Value("${db.username}")
    private String dbUserName;
    
    @Value("${db.password}")
    private String dbPassword;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }    

    @Bean(initMethod = "start",destroyMethod = "stop")
    public Server h2Console() throws SQLException{
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
    }
}
