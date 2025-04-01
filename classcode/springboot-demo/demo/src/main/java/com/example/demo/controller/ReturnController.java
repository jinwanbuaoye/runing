package com.example.demo.controller;

import com.example.demo.moudle.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/return")
//@RestController
//使⽤的 @RestController 其实是返回的数据.
//@RestController = @Controller + @ResponseBody
//@Controller : 定义⼀个控制器, Spring 框架启动时加载, 把这个对象交给Spring管理.
//@ResponseBody : 定义返回的数据格式为⾮视图, 返回⼀个 text/html 信息
@Controller//告诉Spring，帮我们管理这个代码
public class ReturnController {
    @RequestMapping("/mage")
    public String returnMage(){ //返回静态页面
        return "/mage.html";
    }

    @ResponseBody
    @RequestMapping("/returnData")
    public String returnData(){ //返回数据，使用@ResponseBody（修饰类的时候，表示类下面的方法，返回的均为数据；修饰方法，表示方法返回的是数据）
        return "返回数据";
    }

    @ResponseBody
    @RequestMapping("/returnHtml")
    public String returnHtml(){ //返回代码片段
        return "<h1>返回HTML的代码片段</h1>";
    }

    @ResponseBody
    @RequestMapping("/returnJson")
    public Person returnJson(){ //返回json;当接口返回的是对象（String）时，content-Type自动设置为application/json（text/html）
        Person person = new Person();
        person.setId(1);
        person.setName("wang");
        person.setAge(18);
        return person;
    }

    @ResponseBody
    @RequestMapping("/returnMape")
        public Map<String,String> returnMape(){ //返回json;当接口返回的是Map时，content-Type自动设置为application/json
        Map<String,String> kv = new HashMap<>();
        kv.put("k1","v1");
        kv.put("k2","v2");
        kv.put("k3","v3");
        return kv;
    }

    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response){ //设置http状态码
        response.setStatus(401);//通常表示没有登录
        return "设置状态码";
    }

    @RequestMapping(value = "/r1",produces = "application/json;charset=utf-8")//设置返回类型
    @ResponseBody
    public String r1(HttpServletResponse response) {
        return "{'ok':1}";
    }
}
