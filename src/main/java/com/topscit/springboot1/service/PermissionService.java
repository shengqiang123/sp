package com.topscit.springboot1.service;

import java.util.List;

import com.topscit.springboot1.bean.Permission;
import com.topscit.springboot1.bean.Role;
import com.topscit.springboot1.bean.User;

public interface PermissionService {

	public List<Permission> getPermissionList();
	
	User getUserByName(String usercode);
	
	List<Role> getRoleListAndPermission(String id);
}
