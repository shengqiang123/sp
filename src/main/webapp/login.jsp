<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	<form action="login" method="post" >
		<input type="text" name="uname" >
		<input type="password" name="upass" >
		<input type="submit"  value="提交">
	</form>
	${param.msg }
</body>
</html>
