package com.fdzc.springboot01.mapper;

import com.fdzc.springboot01.vo.DeptVo;


public interface DeptMapper {

    /**
     * 查询当前部门信息，包括此部门对应的用户信息
     * @param id 部门编号
     * @return 部门信息+部门员工信息
     */
    DeptVo findDeptUsers(Integer id);

}
