package com.springcloud.finchley.eurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient // 开启客户端
@RestController
@EnableCircuitBreaker // 开启断路器
public class EurekaClientApplication {

    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        System.out.println("----- eureka client start ... -----");
        SpringApplication.run(EurekaClientApplication.class, args);
        System.out.println("----- eureka client start success -----");
    }

    /** Hystrix begin */
    @RequestMapping("/fail")
    @HystrixCommand(fallbackMethod =  "getUserByIds") // 指定异常回退方法
    public String fail(String name) throws Exception {
        throw new Exception();
    }

    // 回退方法，要与被回退方法在同一个类
    @HystrixCommand
    public String getUserByIds(String name) {
        return "fail, name: " + name;
    }
    /** Hystrix end */

    @RequestMapping("/index")
    public String index() {
        return "eureka client port : " + port;
    }

}
