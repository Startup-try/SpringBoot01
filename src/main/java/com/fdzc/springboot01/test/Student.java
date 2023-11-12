package com.fdzc.springboot01.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:/application.properties")
public class Student {
    @Value("${no}")
    public int no;
    @Value("${name}")
    public String name;
    @Value("${age}")
    public int age;
    @Value("${grade}")
    public int grade;


    public void SayHi(){
        System.out.println("Hi~~~~~~~~~");
    }

    public Student(int no, String name, int age, int grade) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Student() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
