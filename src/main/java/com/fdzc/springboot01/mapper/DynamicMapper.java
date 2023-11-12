package com.fdzc.springboot01.mapper;

import com.fdzc.springboot01.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DynamicMapper {

    List<User> selectDynamicIf(Map map);

    Integer deleteByIds(@Param("ids") Integer[] ids);

}
