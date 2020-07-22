package com.chens.stwo.config;

import com.chens.stwo.common.DbInitializer;
import com.chens.stwo.common.RethinkDBConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RethinkDBConfiguration {

    public static final String DBHOST = "127.0.0.1";
    public static final int DBPORT = 28015;

    @Bean
    public RethinkDBConnectionFactory connectionFactory () {
        return new RethinkDBConnectionFactory(DBHOST,DBPORT);
    }

    /*@Bean
    DbInitializer dbInitializer() {
        return new DbInitializer();
    }*/


}
