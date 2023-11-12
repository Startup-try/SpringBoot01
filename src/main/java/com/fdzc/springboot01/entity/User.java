package com.fdzc.springboot01.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {
    public Integer id;

    public String userName;
    public String password;
    public Integer deptId;

    public User() {
    }

    public User(Integer id, String userName, String password, Integer deptId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
