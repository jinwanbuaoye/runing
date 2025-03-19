package com.example.dmo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {
    @Bean
    public String name(){
        return "zhangsan1";
    }

//    @Bean
//    public String name2(){
//        return "wangwu";
//    }

    @Primary //指定该bean为默认bean的实现
    @Bean
    public UserInfo userInfo(String name){//根据名称去拿，如果需要的Bean类型，对应的对象只有一个，就直接赋值，如果多个，根据名称赋值
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName(name);
        userInfo.setAge(10);
        return userInfo;
    }

    @Bean
    public UserInfo userInfo2(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setName("lisi");
        userInfo.setAge(100);
        return userInfo;
    }
}
