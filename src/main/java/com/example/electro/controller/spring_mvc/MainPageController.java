package com.example.electro.controller.spring_mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping("/")
public class MainPageController {

    @RequestMapping
    public String index() {
        return "index";
    }

}
