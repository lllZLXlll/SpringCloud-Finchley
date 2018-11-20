package com.springcloud.finchley.feign.failback;

import com.springcloud.finchley.feign.service.IndexService;
import org.springframework.stereotype.Component;

@Component
public class FailBack implements IndexService {
    @Override
    public String index() {
        return "index exception";
    }
}
