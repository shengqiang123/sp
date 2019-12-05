<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Insert title here</title>
</head>
<body>
	
	<shiro:authenticated >
		<shiro:principal property="id" ></shiro:principal>
	</shiro:authenticated>
	
	<shiro:hasPermission name="user:updatePass" >
		<a href="user/updatePass?newPass=123">修改密码</a>
	</shiro:hasPermission>
	
</body>
</html>
