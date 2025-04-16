package com.bite.trans.controller;

import com.bite.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    private TransactionDefinition transactionDefinition;

    @Autowired
    private UserService userService;

    @RequestMapping("/registry")
    public String registry(String userName, String password) {
      //开启事务
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);

        //用户注册
        Integer result = userService.registryUser(userName, password);
        log.info("用户插入成功，result:"+result);

        //提交事务
        dataSourceTransactionManager.commit(transaction);

        //回滚事务
        //dataSourceTransactionManager.rollback(transaction);

        return "注册成功";
    }
}
