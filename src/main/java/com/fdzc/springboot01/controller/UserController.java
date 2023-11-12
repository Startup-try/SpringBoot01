package com.fdzc.springboot01.controller;

import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.service.UserService;
import com.fdzc.springboot01.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userServiceImpl;
//
//
//    //@RequestMapping(value="/register",method = RequestMethod.POST)
//    @PostMapping("/register")
//    public String Register(@RequestBody  User user){
//        if(userServiceImpl.Register(user)){
//            return "注册成功";
//        }else{
//            return "注册失败";
//        }
//
//
//
//    }
//
//    @PostMapping("/multipleRegister")
//    public String MultipleRegister(@RequestBody List<User> users){
//        if(userServiceImpl.MultipleRegister(users)){
//            return "批量注册成功";
//        }else{
//            return "批量注册失败";
//        }
//    }
//
//    @GetMapping("/login")
//    public String Login(@RequestBody User user){
//        if(userServiceImpl.login(user)){
//            return "登录成功";
//        }else{
//            return  "登录失败";
//        }
//    }
//
//    @GetMapping("/getByName")
//    public User GetByName(String name){
//        return userServiceImpl.GetByName(name);
//    }
//
//    @GetMapping
//    public List<User> GetAll(){
//        return userServiceImpl.GetAllUser();
//    }
//
//
//    @PutMapping
//    public String ModifyUser(@RequestBody User user){
//        userServiceImpl.ModifyUser(user);
//        return "修改成功";
//    }
//
//
//    @PutMapping("/modifyMultipleUser")
//    public String ModifyUser(@RequestBody List<User> users){
//        userServiceImpl.ModifyMultipleUser(users);
//        return "批量修改成功";
//    }

//    @DeleteMapping("/deleteUserByName")
//    public String DeleteUser(String name){
//        userServiceImpl.DeleteByName(name);
//        return "删除成功";
//    }

}
