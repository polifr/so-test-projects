package com.example.linewebhookjava.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class Datasource1Configuration {

    @Bean
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties DataSource1Properties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSource1Properties()
            .initializeDataSourceBuilder()
            .build();
    }
}
