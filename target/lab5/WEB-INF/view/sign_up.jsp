<%--
  Created by IntelliJ IDEA.
  User: kubat
  Date: 19.03.2022
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<br>
<br>
<br>
<h2 class="text-center">Registration</h2>
<br>
<br>
<form action="/lab5_war_exploded/login" class="text-center">
    <p>
        <span class="fs-6">Email: </span>
        <input class="form-control w-25 mx-auto" type="text" name="email">
    </p>
    <p>
        <span class="fs-6">Password: </span>
        <input class="form-control w-25 mx-auto" type="text" name="password">
    </p>
    <br>
    <button type="submit" class="btn btn-warning">Sign up</button>
</form>
</body>
</html>
