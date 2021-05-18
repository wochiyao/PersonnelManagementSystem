<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>主页</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	 <div class="leftContent">
		<div class="title">
			管理系统
		</div>
		<div class="text">员工管理</div>
		<div class="text">考勤管理</div>
		<div class="text">绩效管理</div>
		<div class="text">系统管理</div>
	</div>
    <div class="nav">
        <a class="logout" href="${pageContext.request.contextPath}/logout">退出</a>
        <a class="updatePwd" href="${pageContext.request.contextPath}/update">修改密码</a>
        <a class="admin" href="${pageContext.request.contextPath}/admin">管理</a>
        <label class="userName">${user.name}</label>
        <img class="user" src="images/yh.png" />
    </div>
    <br><br><br>
    <div class="tip">${msg}</div>

</body>
</html>