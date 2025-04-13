package com.bite.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
//@Component
public class AspectDemo {
    //定义切点(公共的切点表达式)
    @Pointcut("execution(* com.bite.demo.controller.*.*(..))")
    public void pt(){

    }

    //前置通知
    @Before("pt()")
    public void doBefore() {
        log.info("执⾏ Before ⽅法");
    }

    //后置通知
    @After("pt()")
    public void doAfter() {
        log.info("执⾏ After ⽅法");
    }

    //返回后通知
    @AfterReturning("execution(* com.bite.demo.controller.*.*(..))")
    public void doAfterReturning() {
        log.info("执⾏ AfterReturning ⽅法");
    }
    //抛出异常后通知
    @AfterThrowing("execution(* com.bite.demo.controller.*.*(..))")
    public void doAfterThrowing() {
        log.info("执⾏ doAfterThrowing ⽅法");
    }
    //添加环绕通知
    @Around("execution(* com.bite.demo.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around ⽅法开始执⾏");
        Object result = joinPoint.proceed();
        log.info("Around ⽅法结束执⾏");
        return result;
    }
}
