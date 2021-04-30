package com.lagou.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.lagou")
@Import(DataSourceConfig.class)
public class SpringConfig {



    @Bean("queryRunner")
    public QueryRunner getQueryRunner(@Autowired  DataSource dataSource){

        QueryRunner queryRunner = new QueryRunner(dataSource);
        return  queryRunner;
    }




}
