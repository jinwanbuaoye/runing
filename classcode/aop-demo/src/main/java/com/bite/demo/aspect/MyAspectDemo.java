package com.bite.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspectDemo {
    //前置通知
    @Before("@annotation(com.bite.demo.aspect.MyAspect)")
    public void before(){
        log.info("MyAspect -> before ...");
    }
    //后置通知
    @After("@annotation(com.bite.demo.aspect.MyAspect)")
    public void after(){
        log.info("MyAspect -> after ...");
    }
}
