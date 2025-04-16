package com.bite.trans.controller;

import com.bite.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/trans")
@RestController
public class TransController {
    @Autowired
    private UserService userService;
    @Transactional//进入方法时自动开启事务, 方法执行完会自动提交事务, 如果中途发生了没有处理的异常会自动回滚事务.
    @RequestMapping("/registry")
    public String registry(String userName, String password) {

        //用户注册
        Integer result = userService.registryUser(userName, password);
        log.info("用户插入成功，result:"+result);

        return "注册成功";
    }

    /**
     * 抛出异常
     * 程序出错，没有处理
     */
    @Transactional//
    @RequestMapping("/registry2")
    public String registry2(String userName, String password) {

        //用户注册
        Integer result = userService.registryUser(userName, password);
        log.info("用户插入成功，result:"+result);
        int a = 10/0;
        return "注册成功";
    }

    /**
     * 程序报错，捕获异常
     * 事务提交
     */
    @Transactional//运行程序, 发现虽然程序出错了, 但是由于异常被捕获了, 所以事务依然得到了提交.
    @RequestMapping("/registry3")
    public String registry3(String userName, String password) {

        //用户注册
        Integer result = userService.registryUser(userName, password);
        log.info("用户插入成功，result:"+result);
        //对异常进行捕获
        try {
        //强制程序抛出异常
            int a = 10/0;
        }catch (Exception e){
            log.info("程序出错");
        }
        return "注册成功";
    }

    /**
     * 将异常重新抛出去
     */
    @Transactional//
    @RequestMapping("/registry4")
    public String registry4(String userName, String password) {

        //用户注册
        Integer result = userService.registryUser(userName, password);
        log.info("用户插入成功，result:"+result);
        //对异常进行捕获
        try {
            //强制程序抛出异常
            int a = 10/0;
        }catch (Exception e){
            log.info("程序出错");
            throw e;//将异常重新抛出去
        }
        return "注册成功";
    }

    /**
     * 手动回滚事务
     */
    @Transactional//
    @RequestMapping("/registry5")
    public String registry5(String userName, String password) {

        //用户注册
        Integer result = userService.registryUser(userName, password);
        log.info("用户插入成功，result:"+result);
        //对异常进行捕获
        try {
            //强制程序抛出异常
            int a = 10/0;
        }catch (Exception e){
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "注册成功";
    }
}

