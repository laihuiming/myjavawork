<%--
  Created by IntelliJ IDEA.
  User: Ace
  Date: 2021/6/14
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>学生信息表</title>
    <meta charset="UTF-8">
</head>

<body>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <script>
        获取当前URL数据
        function getQueryString(name) {
            var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                return unescape(r[2]);
            }
            return null;
        }
        var i = getQueryString("page");
        function last() {
            if (i != 1) {
                i = i--;
                window.location.href = "/work/student?page=" + i + "&rows=" + 5;
            } else if (i = 1){
                i = 1;
                window.location.href = "/work/student?page=" + i + "&rows=" + 5;
            }
        }
        function next() {
                i = i++;
                window.location.href = "/work/student?page=" + i + "&rows=" + 5;
        }

    </script>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>
                <a href="/work/student?method=deleteById&id=${student.id}">删除</a>
                <a href="/work/update.jsp?method=findById&id=${student.id}">修改</a>
<%--                <a href="/work/update.jsp?method=findById&id=${student.id}&name=${student.name}&age=${student.age}">修改</a>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<input class="btn1" type="submit" value="上一页" onclick="last()">
<form action="/work/student?page=1&rows=5" method="post" id="pageForm">
<td class="input">
<%--    <input type="text" name="page" id="page" placeholder="输入页码" class="page_input"/>--%>
    <input type="text" name="page" placeholder="输入页码" value="${student.page}">
    <a href="/work/student?method=findStudentByPage1">查询</a>
</td>
</form>
<input class="btn2" type="submit" value="下一页" onclick="next()">

</body>
</html>
