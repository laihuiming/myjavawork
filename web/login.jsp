<%--
  Created by IntelliJ IDEA.
  User: laihuiming
  Date: 2021/6/16
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:out value="${userusername} " escapeXml="false">
    <a href="/work/login">登录界面</a>
</c:out>
<html>
<head>
    <title>用户登录界面</title>
</head>
<body>
<form action="/work/login" method="post" id="loginFormm">
    <table border="0">
        <tr>
            <td class="title">用户名</td>
            <td class="input">
                <input type="text" name="username" id="username" placeholder="请输入您的账号" class="login_input"/>
            </td>
        </tr>
        <tr>
            <td class="title">密码:</td>
            <td class="input">
                <input type="password" name="password" id="password" placeholder="请输入您的密码" class="login_input"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="btn" type="submit" value="登录"/>
                <input type="reset" value="重置"/>
                <a href="register.jsp" target="_blank">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
