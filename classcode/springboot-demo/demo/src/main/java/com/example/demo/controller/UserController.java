package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName,String password,HttpSession session){
        //检验参数合法性
        /*if (username == null || username.length() == 0 || password == null || password.length() == 0){
            return false;
        }*/
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        //进行用户密码校验
        if("admin".equals(userName) && "admin".equals(password)){
            //设置session
            session.setAttribute("username","admin");
            return true;
        }
        return false;
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session){
        //从session获取登录用户
        String userName = (String) session.getAttribute("username");
        return userName;
    }
}
