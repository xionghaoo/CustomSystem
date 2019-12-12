<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: xionghao
  Date: 2019-12-12
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="users" type="java.util.Hashtable<java.lang.Long, xh.zero.site.User>"--%>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<h2>当前用户列表</h2>
<ol>
    <c:forEach items="${users}" var="user">
    <li>user: ${user.value.name}
        <span style="margin-left: 20px">
            <a href="edit/${user.value.id}">Edit</a>
        </span>
    </li>
    </c:forEach>
</ol>
<a href="add">添加用户</a>
</body>
</html>
