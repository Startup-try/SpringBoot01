package com.fdzc.springboot01;


import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.mapper.DynamicMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisDynamicDemo {
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
    public void selectDynamicIfTest(){
        SqlSession sqlSession = MyBatisDynamicDemo.getSqlSession();
        DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
        Map map = new HashMap();
        //map.put("id",4);
        //map.put("user_name","张飞");
        List<User> users = mapper.selectDynamicIf(map);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void deleteByIdsTest(){
        SqlSession sqlSession = MyBatisDynamicDemo.getSqlSession();
        DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
        Integer num = mapper.deleteByIds(new Integer[]{1,2});
        System.out.println(num);
        sqlSession.close();
    }

}
