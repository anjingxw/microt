package com.zzh.micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "user/changepwd :: changepwd";
    }
}
