package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/sayhi",method = RequestMethod.GET)//可以使用 method 属性来限制请求方式
    public String sayHi(){
        return "hello";
    }
    @RequestMapping("/sayHi/a")
    public String sayhi(){
        int a = 10/0;
        return "hellllllllo";
    }
}
