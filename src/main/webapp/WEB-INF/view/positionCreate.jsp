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
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Create position</h2>
<br>
<form action="/lab5_war_exploded/position/create">
    <span class="fs-5">Position: </span>
    <input class="form-control w-25" type="text" name="position">
    <br> <br>
    <button type="submit" class="btn btn-primary">Create</button>
</form>
<br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>

</body>
</html>
