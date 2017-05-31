<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>custom page</title>
</head>
<body>
	<div>This is a custom page.</div>
	
	<shiro:hasAnyRoles name="role1,role2">
		<div style="color: #08c;">has role1 or role2...</div>
	</shiro:hasAnyRoles>
	
	<shiro:hasRole name="role1">
		<div style="color: red;">only has role1...</div>
	</shiro:hasRole>
	
	<shiro:authenticated>已登录用户</shiro:authenticated>
	
	<shiro:hasPermission name="permission1">
		<div style="color: #08c;">has permission1...</div>
	</shiro:hasPermission>
</body>
</html>