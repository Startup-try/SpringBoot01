package com.fdzc.springboot01.mapper;

import com.fdzc.springboot01.entity.User;
import com.fdzc.springboot01.vo.UserVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper {

    /**
     * 新增用户数据方法
     * @return 新增结果
     */
    //@Insert("insert into user(user_name,password) values('王五','258')")

    Integer insert();

    /**
     * 删除数据方法
     * @return 影响行数
     */
    //@Delete("delete from user where id=3")
    Integer delete();


    /**
     * 修改数据方法
     * @return 影响行数
     */
    @Update("update user set user_name='honghaier' where id = 13")
    Integer update();

    /**
     * 简单查询方法，查询一条记录
     * @return user对象，表示一条数据
     */
    @Select("select * from user where id = 2")
    User select();

    /**
     * 查询全部数据
     * @return list集合表示所有的user数据
     */
    @Select("select * from user")
    List<User> selectAll();

    /**
     * 通过用户传递的id来查询用户信息
     * @param id 用户传递的id
     * @return 返回具体用户数据
     */
    @Select("select * from user where id = #{id}")
    User selectById(Integer id);

    /**
     * 通过用户传递的表名和id来查询具体数据
     * @param table 表名
     * @param id 用户传递的id
     * @return 返回具体用户数据
     */
    @Select("select * from ${table} where id = #{id}")
    User selectByIdAndTable(
            @Param("table") String table,
            @Param("id") Integer id
    );

    /**
     * 通过Map查询用户数据
     * @param map 需要获得的参数
     * @return 查询结果
     */
    @Select("select * from user where user_name=#{user_name} and password=#{password}")
    User selectByUsernameAndPassword(Map<String,Object> map);

    /**
     * 通过User实体类 来新增数据
     * @param user 实体类
     * @return 影响行数
     */
    @Insert("insert into user(user_name,password,dept_id) values(#{userName},#{password},#{deptId})")
    Integer insertToUser(User user);

    /**
     * 根据用户id查询数据，并且将数据转换为Map
     * @param id 参数
     * @return 转换的Map数据
     */
    @Select("select * from user where id=#{id}")
    Map<String,Object> findUserToMap(Integer id);


    /**
     * 查询user表中全部的数据，并且转换为map
     * @return list集合中存放Map
     */
    @Select("select * from user")
    List<Map<String,Object>> findUserAllToMap();
//    @MapKey("id")
//    Map<String,Object> findUserAllToMap();

    @Insert("insert into user(user_name,password) values(#{userName},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insertToOne(User user);

    @Select("select * from user limit #{startIndex},#{pageSize}")
    List<User> selectUserLimit(Map<String,Integer> map);

    List<UserVo> findUserDept();


}
