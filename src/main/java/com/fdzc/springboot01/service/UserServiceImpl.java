package com.fdzc.springboot01.service;

import com.fdzc.springboot01.dao.UserDAO;
import com.fdzc.springboot01.dao.UserDAOImpl;
import com.fdzc.springboot01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{



    @Autowired
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Boolean Register(User user) {
        userDAO.Insert(user);
        return true;
    }

    @Override
    public Boolean MultipleRegister(List<User> users) {
        for(User user : users){
            Register(user);
        }
        return true;
    }

    @Override
    public Boolean login(User user) {
        return userDAO.GetByNameAndPW(user) != null;

    }

    @Override
    public User GetByName(String name) {
        return userDAO.GetByName(name);
    }

    @Override
    public User GetByID(int id) {
        return userDAO.GetByID(id);
    }

    @Override
    public List<User> GetAllUser() {
        return userDAO.GetALL();

    }

    @Override
    public void ModifyUser(User User) {
        userDAO.Updata(User);

    }

    @Override
    public void ModifyMultipleUser(List<User> users) {
        for(User user : users){
            ModifyUser(user);
        }

    }

    @Override
    public void DeleteByName(int id) {
        userDAO.DeleteByName(id);

    }
}
