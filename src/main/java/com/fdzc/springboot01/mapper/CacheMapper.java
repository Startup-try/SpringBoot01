package com.fdzc.springboot01.mapper;

import com.fdzc.springboot01.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CacheMapper {

    //@Select("select * from user where id=#{id}")
    User selectById(Integer id);

    @Update("update user set user_name=#{username} where id = #{id}")
    Integer updateById(
            @Param("id") Integer id,
            @Param("username") String userName
    );

}
