package com.bite.demo.controller;

import com.bite.demo.aspect.MyAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConteroller {
    @RequestMapping("/t1")
    public String t1(){
        return "t1";
    }

    @MyAspect
    @RequestMapping("/t2")
    public String t2(){
        return "t2";
    }
}
