package com.bite.book.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        //校验
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(userName)){
            return false;
        }
        if("111".equals(userName) && "111".equals(password)){
            //账号密码正确，存Session
            session.setAttribute("userName",userName);
            return true;
        }
        /*if(userName.equals("111")){
            //如果·userName为null，会报空指针异常
        }*/
        return false;
    }
}
