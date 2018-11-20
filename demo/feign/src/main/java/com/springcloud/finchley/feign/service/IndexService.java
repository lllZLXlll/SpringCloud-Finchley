package com.springcloud.finchley.feign.service;

import com.springcloud.finchley.feign.failback.FailBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 指定服务名称，指定异常回调
@FeignClient(value = "eureka-client", fallback = FailBack.class)
public interface IndexService {

    @GetMapping("/index")
    String index();

}
