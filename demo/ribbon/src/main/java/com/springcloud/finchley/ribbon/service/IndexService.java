package com.springcloud.finchley.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IndexService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "indexFailBackMethod")
    public String index() {
        return restTemplate.getForObject("http://eureka-client/index", String.class);
    }

    private String indexFailBackMethod() {
        return "index error";
    }

    // 指定异常回调方法
    @HystrixCommand(fallbackMethod = "failBackMethod")
    public String hystrix() throws Exception {
        throw new Exception("exception");
    }

    private String failBackMethod() {
        return "出现异常";
    }

}
