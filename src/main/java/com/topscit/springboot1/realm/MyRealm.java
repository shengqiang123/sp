package com.topscit.springboot1.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.topscit.springboot1.bean.Permission;
import com.topscit.springboot1.bean.Role;
import com.topscit.springboot1.bean.User;
import com.topscit.springboot1.service.PermissionService;

public class MyRealm extends AuthorizingRealm{

	@Resource
	private PermissionService permissionService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo;
		try {
			User user = (User)principals.getPrimaryPrincipal();
			List<Role> roleListAndPermission = permissionService.getRoleListAndPermission(user.getId());
			
			simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			for (Role role : roleListAndPermission) {
				simpleAuthorizationInfo.addRole(role.getName());
				List<Permission> permissionList = role.getPermissionList();
				for (Permission p : permissionList) {
					simpleAuthorizationInfo.addStringPermission(p.getPercode());
				}
			}
			return simpleAuthorizationInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		try {
			String principal = (String)token.getPrincipal();
			User user = permissionService.getUserByName(principal);
			if(user == null)
			{
				return null;
			}
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),ByteSource.Util.bytes(user.getSalt()) , "myrealm");
			return authenticationInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
