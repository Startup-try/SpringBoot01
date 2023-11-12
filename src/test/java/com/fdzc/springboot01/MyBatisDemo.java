package com.fdzc.springboot01;

import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.mapper.DeptMapper;
import com.fdzc.springboot01.mapper.UserMapper;
import com.fdzc.springboot01.vo.DeptVo;
import com.fdzc.springboot01.vo.UserVo;
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

public class MyBatisDemo {

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
    public void test() throws IOException {
        //读取MyBaits的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象可以获取SQL语句，并执行）
        //注意：openSession对象默认是不会进行自动的事务提交的,所以我们如果想做DML操作并且自动事务提交，需要加上true参数，默认为false
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取Mapper对象(代理模式-》可以帮助我们返回当前接口的实例化对象)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        Integer num = userMapper.insert();
        //手动提交
        //sqlSession.commit();
        System.out.println(num);
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer num = userMapper.delete();
        System.out.println(num);
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer num = userMapper.update();
        System.out.println(num);
    }

    @Test
    public void selectTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select();
        System.out.println(user);
    }

    @Test
    public void selectAllTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        users.forEach(user-> System.out.println(user));
    }

    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(4);
        System.out.println(user);
    }

    @Test
    public void selectByIdAndTableTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByIdAndTable("user",5);
        System.out.println(user);
    }

    @Test
    public void selectByUsernameAndPasswordTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //手动将参数放入到map中
        Map<String,Object> map = new HashMap<>();
        map.put("user_name","张飞");
        map.put("password","ccccccc");
        User user = userMapper.selectByUsernameAndPassword(map);
        System.out.println(user);
    }

    @Test
    public void insertToUserTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"sunwukong2222","753",3);
        Integer num = userMapper.insertToUser(user);
        System.out.println(num);
    }

    @Test
    public void findUserToMapTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> users = userMapper.findUserToMap(5);
        System.out.println(users);
    }

    @Test
    public void findUserAllToMapTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String,Object>> users = userMapper.findUserAllToMap();
        System.out.println(users);
    }

    @Test
    public void insertToOneTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"小王333","354",1);
        Integer num = userMapper.insertToOne(user);
        System.out.println(user);
    }

    @Test
    public void selectUserLimitTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<>();
        int currentPage = 2;//第几页
        int pageSize = 8;//每页显示几个
        //起始位置 = (当前页-1)*页面大小
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> users = userMapper.selectUserLimit(map);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void findUserDeptTest(){
        SqlSession sqlSession = MyBatisDemo.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserVo> list = userMapper.findUserDept();
        list.forEach(user-> System.out.println(user));
    }

    @Test
    public void findDeptUsersTest(){
        try {
            SqlSession sqlSession = MyBatisDemo.getSqlSession();
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            DeptVo vo = deptMapper.findDeptUsers(2);
            System.out.println(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
