package com.topscit.springboot1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topscit.springboot1.bean.Permission;
import com.topscit.springboot1.bean.Role;
import com.topscit.springboot1.bean.User;
import com.topscit.springboot1.dao.PermissionMapper;
import com.topscit.springboot1.dao.UserMapper;
import com.topscit.springboot1.service.PermissionService;


@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{

	
	@Resource
	private UserMapper userMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> getPermissionList() {
		
		List<Permission> permissionList = permissionMapper.getPermissionList();
		return permissionList;
	}
	

	@Override
	public User getUserByName(String usercode) {
		User user = userMapper.selectByUserCode(usercode);
		return user;
	}

	@Override
	public List<Role> getRoleListAndPermission(String id) {
		return userMapper.getRole(id);
	}


}
