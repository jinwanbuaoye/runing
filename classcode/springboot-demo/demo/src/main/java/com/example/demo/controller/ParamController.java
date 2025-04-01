package com.example.demo.controller;

import com.example.demo.moudle.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/param")
@RestController
public class ParamController {
    @RequestMapping("/m1")
    public String m1(String name){
        return "接受的参数name:"+name;
    }

    @RequestMapping("/m2")
    public String m2(String name,Integer age){
        return "接受的参数name:"+name + ",age:"+age;
    }

    @RequestMapping("/m3")
    public String m3(String name,int age){
        return "接受的参数name:"+name + ",age:"+age;// 如果使用基本类型，必须传值
    }

    @RequestMapping("/m4")
    public String m4(Person person){
        return "接受的参数person:"+person.toString();// 传递对象
    }

    @RequestMapping("/m5")
    public String m5(@RequestParam(value = "name",required = false) String username){
        return "接受的参数name:"+username;// 将name重命名。name成了必传参数,required = false修改，
    }

    @RequestMapping("/m6")//数组
    public String m6(String[] arrayParm){     //arrayParm=zhangsan&arrayParm=san&arrayParm=zhang   arrayParm=zhangsan,san,zhang
        return "接受的参数arrayParm:"+ Arrays.toString(arrayParm) + ",长度:"+ arrayParm.length;//接受的参数arrayParm:[zhangsan, san, zhang]
    }

    @RequestMapping("/m7")  //传递集合
    public String m7(@RequestParam List<String> listParm){
        return "接受的参数listParm:"+ listParm + ",长度:"+ listParm.size();
    }

    @RequestMapping("/m8")  //传递JSON数据，需要用到@RequestBody
    public String m8(@RequestBody Person person){
        return "接受的数据person:"+ person.toString();
    }

    @RequestMapping("/m9/{userId}/{name}")  //获取URL中的参数, @PathVariable
    public String m9(@PathVariable Integer userId,@PathVariable String name){
        return "userId:"+ userId + ",name:"+name;
    }

    @RequestMapping("/m10")  //上传文件
    public String m10(@RequestParam MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("D:/three/"+file.getOriginalFilename()));//把文件保存到本地
        return "success";
    }

    @RequestMapping("/getCookie")//原来获取cookie方式
    public String getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        /*for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+":"+cookie.getValue());
        }*/
        if (cookies!=null){
            Arrays.stream(cookies).forEach(cookie -> {
                System.out.println(cookie.getName()+":"+cookie.getValue());
            });
        }
        return "获取cookie成功";
    }

    @RequestMapping("/getCookie2")//使用注解方式，只能一个一个cookie拿
    public String getCookie2(@CookieValue String bite,@CookieValue String aaa){
        return "cookie存取的值bite："+bite+"  cookie存取的值aaa："+aaa;
    }

    @RequestMapping("/setSession")//设置session
    public String setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username","zhangsan");
        return "success";
    }

    @RequestMapping("/getSession")//获取session
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);//没有session，会创建一个session
        if (session != null){
            String username = (String)session.getAttribute("username");
            return "登录用户："+username;
        }
        return "session为空";
    }

    @RequestMapping("/getSession2")//获取session
    public String getSession2(@SessionAttribute(required = false) String username){
        return "username:"+username;
    }

    @RequestMapping("/getSession3")//获取session
    public String getSession3(HttpSession session){//等同于 HttpSession session = request.getSession(ture);
        String username = (String)session.getAttribute("username");
        return "登录用户："+username;
    }

    @RequestMapping("/getHeader")//获取session
    public String getHerder(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return "userAgent:"+userAgent;
    }

    @RequestMapping("/header")//简洁获取 Header
    public String header(@RequestHeader("User-Agent") String userAgent) {
        return "userAgent："+userAgent;
    }
}
