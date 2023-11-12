package com.fdzc.springboot01;

import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.test.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringBoot01ApplicationTests {

    @Test
    void SetTest() {

        User user = new User();
        user.setUserName("wangpeng");
        user.setPassword("123456");
        System.out.println(user);

    }

    @Test
    void ContructorTest(){
        User user = new User(1,"haoyu","123456",1);
        System.out.println(user);
    }

    @Test
    void xmlTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ioc.xml");
        User user = (User)ctx.getBean("userrr");
        System.out.println(user);
    }



    @Test
    void StudentTest1(){
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(22);
        student.setNo(001);
        System.out.println(student);
    }

    @Test
    void StudentTest2(){
        Student student = new Student(2,"lisi",23,2);
        System.out.println(student);
    }

    //set注入
    @Test
    void StudentTest3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ioc.xml");
        Student student = (Student)ctx.getBean("student");
        System.out.println(student);
    }

    //构造注入
    @Test
    void StudentTest4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ioc.xml");
        Student student = (Student)ctx.getBean("student2");
        System.out.println(student);
    }

    @Test
    void StudentTest5(){
        ConfigurableApplicationContext ioc = SpringApplication.run(SpringBoot01Application.class);
        Student student = (Student)ioc.getBean("student");
        System.out.println(student);
    }

    @Test
    void StudentTest6(){
        ConfigurableApplicationContext ioc = SpringApplication.run(SpringBoot01Application.class);
        Student student1 = (Student)ioc.getBean("SSStudentwww");

        System.out.println(student1);

    }


}
