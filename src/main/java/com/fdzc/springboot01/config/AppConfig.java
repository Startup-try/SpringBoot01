package com.fdzc.springboot01.config;
import com.fdzc.springboot01.test.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


@Configuration  //这是一个配置类
@PropertySource("classpath:/application.properties")
public class AppConfig {

    @Value("${no}")
    private int no;
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;
    @Value("${grade}")
    private int grade;


    @Bean
    @Scope("prototype")
    public Student SSStudentwww(){
        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setAge(age);
        return student;
    }





}
