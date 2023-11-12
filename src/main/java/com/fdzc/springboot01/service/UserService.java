package com.fdzc.springboot01.service;

import com.fdzc.springboot01.entity.User;

import java.util.List;

public interface UserService {

    public Boolean Register(User user);
    public Boolean MultipleRegister(List<User> users);

    public Boolean login(User user);
    public User GetByName(String name);
    public User GetByID(int id);
    public List<User> GetAllUser();

    public void ModifyUser(User User);
    public void ModifyMultipleUser(List<User> users);
    public void DeleteByName(int id);

}
