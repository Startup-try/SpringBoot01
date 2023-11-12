package com.fdzc.springboot01.vo;

import java.io.Serializable;

/**
 * 用于当前业务查询到的数据进行分装
 * 是实体类的一种，查询结果有几列
 * 就封装几个对应的属性
 *
 * 这种vo类型一般用于复杂查询（关联查询）
 */
public class UserVo implements Serializable {
    private Integer id;
    private String userName;
    private String deptName;

    public UserVo() {
    }

    public UserVo(Integer id, String userName, String deptName) {
        this.id = id;
        this.userName = userName;
        this.deptName = deptName;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
