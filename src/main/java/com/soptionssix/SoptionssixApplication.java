package com.soptionssix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.soptionssix.data")
public class SoptionssixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoptionssixApplication.class, args);
    }

}
