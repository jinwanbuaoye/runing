package com.example.dmo.controller;

import com.example.dmo.configuration.UserInfo;
import com.example.dmo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller//将对象存在Spring，控制器存储
public class UserController {
    //注⼊⽅法1: 属性注⼊
    //不能注⼊⼀个Final修饰的属性
    @Autowired
    private UserService userService;

//    /*@Qualifier("userInfo2")//使用Qualifier指定bean名称
//    @Autowired
//    private UserInfo userInfo;*/

    @Resource(name = "userInfo2")//使⽤@Resource注解：是按照bean的名称进⾏注⼊
    private UserInfo userInfo;
    //======================================================================================================
    //注⼊⽅法2:构造方法注入

   /* private UserService userService;
    private UserInfo userInfo;

    public UserController() {

    }

    @Autowired//如果存在多个构造函数，必须指定一个，注明告诉使用哪个构造函数
    public UserController(UserService userService){//如果存在多个构造函数，必须指定一个
        this.userService = userService;
    }

    public UserController(UserService userService, UserInfo userInfo) {
        this.userService = userService;
        this.userInfo = userInfo;
    }*/
//======================================================================================================
    //注⼊⽅法3: Setter方法注⼊
    /*private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
*/
    public void doController(){
        userService.doService();
        System.out.println(userInfo);
        System.out.println("hi,userController");
    }
}
