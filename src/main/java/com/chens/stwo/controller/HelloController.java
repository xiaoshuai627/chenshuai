package com.chens.stwo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    public String sayHello(@RequestParam(name = "name",required = false,defaultValue = "World") String name
    , Model model) {

        model.addAttribute("name",name);
        System.out.println("request.........");
        return  "hello";
    }
}
