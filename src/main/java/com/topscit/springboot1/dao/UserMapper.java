package com.topscit.springboot1.dao;

import java.util.List;

import com.topscit.springboot1.bean.Role;
import com.topscit.springboot1.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
    User selectByUserCode(String userCode);
    
    List<Role> getRole(String id);
}