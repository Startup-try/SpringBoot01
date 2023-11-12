package com.fdzc.springboot01.controller;

import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.service.UserService2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {
    @Autowired
    private UserService2 userService2;
    Logger logger = Logger.getLogger(UserController2.class);


    @RequestMapping("/txTest")
    public String test(@RequestBody User user) throws Exception {
        logger.info(user.toString());//会在控制台和文件中输出
        userService2.insert(user);
        return "success";
    }
}
