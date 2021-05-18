<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class="top">
        修改密码
    </div>
	<div class="updatePwdContent">
		<form action="${pageContext.request.contextPath}/update" method="post">
            <label>新密码</label>
            <br/>
            <input type="password" name="password"/>
            <br/>
            <button>修改</button>
        </form>
        <div class="tip">${msg}</div>
	</div>
	<div class="sign">
       <a href="${pageContext.request.contextPath}/main">返回主页</a>
    </div>
</body>
</html>