package com.fdzc.springboot01.vo;

import com.fdzc.springboot01.entity.User;


import java.io.Serializable;
import java.util.List;

public class DeptVo implements Serializable {
    private Integer id;
    private String deptName;
    private List<User> users;

    public DeptVo() {
    }

    public DeptVo(Integer id, String deptName, List<User> users) {
        this.id = id;
        this.deptName = deptName;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DeptVo{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", users=" + users +
                '}';
    }
}
