package com.topscit.springboot1.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topscit.springboot1.bean.Permission;
import com.topscit.springboot1.service.PermissionService;


@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Resource
	private PermissionService permissionService;
	
	@RequestMapping("/getPermissionList")
	//	@ResponseBody //将返回值转换为json格式字符串
	public String getPermissionList()
	{
		List<Permission> permissionList = permissionService.getPermissionList();
		
		return "";
	}
	
	
}
