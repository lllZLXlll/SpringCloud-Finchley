package com.springcloud.finchley.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IndexService {

    @Autowired
    RestTemplate restTemplate;

    public String index() {
        return restTemplate.getForObject("http://eureka-client/index", String.class);
    }

}
