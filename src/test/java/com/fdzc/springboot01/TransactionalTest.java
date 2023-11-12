package com.fdzc.springboot01;

import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
public class TransactionalTest {

    private static SqlSession getSqlSession(){
        //读取MyBaits的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象可以获取SQL语句，并执行）
        //注意：openSession对象默认是不会进行自动的事务提交的,所以我们如果想做DML操作并且自动事务提交，需要加上true参数，默认为false
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    @Test
    @Transactional(rollbackFor=Exception.class )
    public void TransactionalTest1() throws Exception{
        SqlSession sqlSession = TransactionalTest.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            User user1 = new User();
            user1.setUserName("transactionalTest111");
            user1.setPassword("password111");
            user1.setDeptId(1);
            userMapper.insertToUser(user1);
            int i = 10 / 0;

            User user2 = new User();
            user2.setUserName("transactionalTest222");
            user2.setPassword("password222");
            user2.setDeptId(1);
            userMapper.insertToUser(user2);
        }catch (Exception e){
            throw new Exception();
        }


    }
}
