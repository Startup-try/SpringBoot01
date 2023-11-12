package com.fdzc.springboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@MapperScan({"com.fdzc.springboot01.mapper"})
@ServletComponentScan("com.fdzc.springboot01.filter")
public class SpringBoot01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SpringBoot01Application.class, args);
//        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
//        System.out.println("---------------------");
//        for(String name : beanDefinitionNames){
//            System.out.println("name = " + name);
//        }
//        System.out.println("---------------------");
    }

}
