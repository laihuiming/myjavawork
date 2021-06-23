<%--
  Created by IntelliJ IDEA.
  User: Ace
  Date: 2021/6/22
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
学生信息管理系统<c:out value="${userusername} " escapeXml="false">
    <a>修改信息界面</a>
</c:out>
<html>
<head>
    <title>修改信息页面</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="/work/student" method="post">
<%--    编号:<input type="text" name="id" placeholder="无法修改id" value="${student.id}" readonly><br/>--%>
    编号:<input type="text" name="id" placeholder="请输入id" value="${student.id}"><br/>
    姓名:<input type="text" name="name" placeholder="请输入姓名" value="${student.name}"><br/>
    年龄:<input type="text" name="age" placeholder="请输入年龄" value="${student.age}"><br/>
    <input type="hidden" name="method" value="update">
    <input type="submit" value="修改">
    <c:out value="${userusername} " escapeXml="false">
        <a href="/work/student?page=1&rows=5">返回学生信息界面</a>
    </c:out>
</form>
</body>
</html>
