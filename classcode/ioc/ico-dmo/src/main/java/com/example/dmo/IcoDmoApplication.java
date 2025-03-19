package com.example.dmo;

import com.example.dmo.component.UserComponent;
import com.example.dmo.configuration.UserConfiguration;
import com.example.dmo.configuration.UserInfo;
import com.example.dmo.controller.UserController;
import com.example.dmo.repository.UserRepository;
import com.example.dmo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan("com.example.demo")
@SpringBootApplication
public class IcoDmoApplication {

    public static void main(String[] args) {
        //Spring上下文
        ApplicationContext context = SpringApplication.run(IcoDmoApplication.class, args);
        //从context获取bean
        UserController bean = context.getBean(UserController.class);
        bean.doController();

       /* //根据类型获取bean
        UserService userService1 = context.getBean(UserService.class);
        userService1.doService();

        //根据名称获取bean
        UserService userService2 = (UserService)context.getBean("userService");
        userService2.doService();

        //根据名称和类型获取bean
        UserService userService3 = context.getBean("userService", UserService.class);
        userService3.doService();

        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.doRepository();

        UserComponent userComponent = context.getBean(UserComponent.class);
        userComponent.doComponent();

        UserConfiguration userConfiguration = context.getBean(UserConfiguration.class);
        userConfiguration.doConfiguration();

        //@Bean演示   一个类型存在多个bean，就不能使用类型获取对象，使用名称获取
        UserInfo userInfo =(UserInfo)context.getBean("userInfo2");
        System.out.println(userInfo);

        UserInfo userInfo2 = context.getBean("userInfo", UserInfo.class);
        System.out.println(userInfo2);*/
    }

}
