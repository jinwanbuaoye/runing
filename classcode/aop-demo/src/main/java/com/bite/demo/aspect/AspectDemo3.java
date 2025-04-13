package com.bite.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
//@Component
@Order(1)
public class AspectDemo3 {
    //前置通知
    @Before("com.bite.demo.aspect.AspectDemo.pt()")
    public void doBefore() {
        log.info("执⾏ AspectDemo3 Before ⽅法");
    }

    @After("com.bite.demo.aspect.AspectDemo.pt()")
    public void doAfter() {
        log.info("执⾏ AspectDemo3 After ⽅法");
    }
}
