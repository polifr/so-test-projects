package com.example.linewebhookjava.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "secondEntityManagerFactory",
    transactionManagerRef = "secondTransactionManager",
    basePackages = {"com.example.linewebhookjava.repository.datasource2"}
)
public class Datasource2Config {

    //    @Primary
    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
        EntityManagerFactoryBuilder builder, @Qualifier("dataSource2") DataSource dataSource) {
        return builder
            .dataSource(dataSource)
            .packages("com.example.linewebhookjava.entity.datasource2")
            .persistenceUnit("database_2")
            .build();
    }

    //    @Primary
    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager secondTransactionManager(
        @Qualifier("secondEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}