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
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Update ${name}</h2>
<br>
<form action="/lab5_war_exploded/${url}/do-update/${obj.id}">
    <p>
        <span class="fs-5">City: </span>
        <input class="form-control w-25" type="text" name="city" value="${obj.city}">
    </p>
    <p>
        <span class="fs-5">Venue: </span>
        <input class="form-control w-25" type="text" name="venue" value="${obj.venue}">
    </p>
    <p>
        <span class="fs-5">Start time: </span>
        <input class="form-control w-25" type="time" name="startTime" value="${obj.start_time}">
    </p>
    <p>
        <span class="fs-5">Name: </span>
        <input class="form-control w-25" type="text" name="name" value="${obj.name}">
    </p>
    <p>
        <span class="fs-5">Tour: </span><br>
        <select class="form-select w-25" name="tour">
            <c:forEach var="item" items="${tours}">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
<br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>
</body>
</html>