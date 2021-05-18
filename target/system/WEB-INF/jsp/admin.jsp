<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" import="com.po.User"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
    <div class="top">
        管理
    </div>
    <%
        HttpSession httpSession=request.getSession();
        List<User> list=(List<User>) httpSession.getAttribute("list");
    %>
    <table class="userContent">
        <tr>
            <th>用户名</th>
            <th>操作</th>
        </tr>
        <%
            for(User user : list) {
        %>
        <tr>
            <td><%=user.getName()%></td>
            <td><a href="${pageContext.request.contextPath}/delete/<%=user.getName()%>">删除</a></td>
        </tr>
        <%} %>
    </table>
	<div class="content">
		<form action="${pageContext.request.contextPath}/addUser" method="post">
            <label>用户名</label>
            <br/>
            <input type="text" name="name"/>
            <br/>
            <label>密码</label>
            <br/>
            <input type="password" name="password"/>
            <br/>
            <button>添加</button>
        </form>
        <div class="tip"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></div>
        <div class="tip">${param.msg}</div>
	</div>
	<div class="sign">
        <a href="${pageContext.request.contextPath}/main">返回主页</a>
     </div>
</body>
</html>