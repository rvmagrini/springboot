package com.rvmagrini.springboot.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:h2:mem:/pluralsight/springboot");
        System.out.println("Custom Datasource Bean has been initialized and set");
        return builder.build();
    }

}
