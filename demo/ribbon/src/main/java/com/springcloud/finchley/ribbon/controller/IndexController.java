package com.springcloud.finchley.ribbon.controller;

import com.springcloud.finchley.ribbon.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/index")
    public String index() {
        return indexService.index();
    }

}
