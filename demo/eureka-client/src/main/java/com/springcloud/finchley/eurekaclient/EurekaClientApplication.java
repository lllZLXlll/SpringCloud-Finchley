package com.springcloud.finchley.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient // 客户端发现
@RestController
public class EurekaClientApplication {

    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        System.out.println("----- eureka client start ... -----");
        SpringApplication.run(EurekaClientApplication.class, args);
        System.out.println("----- eureka client start success -----");
    }

    @RequestMapping("/index")
    public String index() {
        return "eureka client port : " + port;
    }
}
