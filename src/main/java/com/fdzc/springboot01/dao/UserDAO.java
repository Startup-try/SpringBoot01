package com.fdzc.springboot01.dao;

import com.fdzc.springboot01.entity.User;

import java.util.List;

public interface UserDAO {

    public void Insert(User user);
    public User GetByNameAndPW(User user);
    public User GetByName(String name);
    public User GetByID(int id);
    public List<User> GetALL();
    public void Updata(User user);
    public void DeleteByName(int id);

}
