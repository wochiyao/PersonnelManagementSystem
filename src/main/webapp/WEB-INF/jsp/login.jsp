<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class="top">
        登录
    </div>
	<div class="content">
		<form action="${pageContext.request.contextPath}/login" method="post">
            <label>用户名</label>
            <br/>
            <input type="text" name="name"/>
            <br/>
            <label>密码</label>
            <br/>
            <input type="password" name="password"/>
            <br/>
            <button>登录</button>
        </form>
        <div class="tip">${msg}</div>
	</div>
	<div class="sign">
        未有账号？ <a href="${pageContext.request.contextPath}/register">创建一个账户</a>
    </div>
</body>
</html>