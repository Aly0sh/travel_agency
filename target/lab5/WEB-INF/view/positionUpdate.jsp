<%--
  Created by IntelliJ IDEA.
  User: kubat
  Date: 19.03.2022
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h2>Update position</h2>
<br>
<form action="/lab5_war_exploded/position/do-update/${id}">
    <span>Position: </span>
    <input type="text" name="position">
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>