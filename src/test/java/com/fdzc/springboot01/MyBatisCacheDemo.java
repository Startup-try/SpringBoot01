package com.fdzc.springboot01;


import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.mapper.CacheMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisCacheDemo {
    private static SqlSessionFactory getSqlSessionFactory(){
        //读取MyBaits的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        return sqlSessionFactory;
    }


    @Test
    public void selectDynamicIfTest(){
        //获取同一个SqlSessionFactory下的SqlSession会话对象
        SqlSessionFactory sqlSessionFactory = MyBatisCacheDemo.getSqlSessionFactory();
        //开启2个会话  sqlSession1开启 一级缓存开启
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        User user = mapper.selectById(5);
        System.out.println(user);
        //一级缓存结束
        sqlSession1.close();
        //同一次sqlSession中有增删改的操作，缓存失效
//        Integer num = mapper.updateById(4,"tom");
//        System.out.println(num);
//        User user1 = mapper.selectById(5);
//        System.out.println(user1);
//        System.out.println(user == user1);

        //手动清除缓存，缓存失效
//        sqlSession1.clearCache();

//        System.out.println("--------------------------------------------");
//
        //开启会话 开启一级缓存
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession2.getMapper(CacheMapper.class);
        User user1 = mapper1.selectById(5);
        System.out.println(user1);
        System.out.println(user==user1);
        //一级缓存结束
        sqlSession2.close();
    }
}
