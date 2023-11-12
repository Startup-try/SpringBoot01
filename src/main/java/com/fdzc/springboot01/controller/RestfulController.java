package com.fdzc.springboot01.controller;

import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//ALTER TABLE user ADD id int primary key auto_increment;
@RestController
@RequestMapping("/users")

public class RestfulController {
    @Autowired
    private UserService userServiceImpl;


    @GetMapping("/{id}")
    public User GetByID(@PathVariable Integer id){
        return userServiceImpl.GetByID(id);
    }

    @GetMapping
    public List<User> GetAll(){
        return userServiceImpl.GetAllUser();
    }

    @PostMapping
    public String Register(@RequestBody User user){
        if(userServiceImpl.Register(user)){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }

    @PutMapping
    public String ModifyUser(@RequestBody User user){
        userServiceImpl.ModifyUser(user);
        return "修改成功";
    }


    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable int id){
        userServiceImpl.DeleteByName(id);
        return "删除成功";
    }

}
