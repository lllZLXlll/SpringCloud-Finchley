package com.springcloud.finchley.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        System.out.println("----- eureka server start ... -----");
        SpringApplication.run(EurekaServerApplication.class, args);
        System.out.println("----- eureka server start success -----");
    }
}
