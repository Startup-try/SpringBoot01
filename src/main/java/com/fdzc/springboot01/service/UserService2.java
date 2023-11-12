package com.fdzc.springboot01.service;

import com.fdzc.springboot01.controller.UserController2;
import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService2 {
    @Autowired
    private UserMapper userMapper;
    Logger logger = Logger.getLogger(UserService2.class);

    @Transactional(rollbackFor=Exception.class)
    public int insert(User user) throws Exception {
//        try {
            logger.info(user.toString() + "________Service");
            userMapper.insertToUser(user);
            //int i = 10 / 0;
            User u = new User();
            u.setUserName("txtest22");
            u.setPassword("txtest222");
            u.setDeptId(1);
            userMapper.insertToUser(u);
//        }catch (Exception e){
//            throw new Exception();
//        }
        return 1;
    }
}
