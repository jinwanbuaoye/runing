package com.bite.book.controller;

import com.bite.book.model.UserInfo;
import com.bite.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        //校验
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(userName)){
            return false;
        }

        //校验密码是否正确
        /*if("111".equals(userName) && "111".equals(password)){
            //账号密码正确，存Session
            session.setAttribute("userName",userName);
            return true;
        }*/
        /*if(userName.equals("111")){
            //如果·userName为null，会报空指针异常
        }*/

        //1.根据用户名查找信息
        UserInfo userInfo = userService.getUserInfoByname(userName);

        //2.比对密码是否正确
        if (userInfo == null || userInfo.getId()<=0){
            return false;
        }
        //账号密码正确
        if(password.equals(userInfo.getPassword())){
            //存储在Session中
            userInfo.setPassword("");
            session.setAttribute("userName",userInfo);
            return true;
        }
        //账号密码错误
        return false;
    }
}
