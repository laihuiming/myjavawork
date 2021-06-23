<%--
  Created by IntelliJ IDEA.
  User: Ace
  Date: 2021/6/22
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="/work/register" method="post">
    账号:<input type="text" name="username" placeholder="请输入您的账号"><br/>
    密码:<input type="text" name="password" placeholder="请输入您的密码"><br/>
    <input type="hidden" name="method" value="register">
    <input type="submit" value="提交注册">
    <input type="reset" value="重置"/>

    <input type="button" value="关闭当前窗口,回到登录界面" onclick="javascript:window.close()">

</form>
</body>
</html>
