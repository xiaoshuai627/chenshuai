package com.chens.stwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    String host = "www.baidu.com";
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/get")
    public String sayHello() {
        String url = host+ "/java";
        return restTemplate.getForObject(url,String.class);
    }
}
