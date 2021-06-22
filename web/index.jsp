<%--
  Created by IntelliJ IDEA.
  User: Ace
  Date: 2021/6/14
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>学生信息表</title>
</head>

<body>
<table>
  <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>年龄</th>
  </tr>
  <%
    //分页
    int pageSize = 5;
    int lineCount;
    int pageCount;
    int pageNow = 1;
  %>
  <c:forEach items="${list}" var="student">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.age}</td>
      <td>
        <a href="/student?method=deleteById&id=${student.id}">删除</a>
        <a href="/student?method=findById&id=${student.id}">修改</a>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
