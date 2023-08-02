package com.java.microservice.usersercives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserSercivesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSercivesApplication.class, args);
    }

}
