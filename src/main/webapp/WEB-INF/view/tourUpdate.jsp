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
        <span class="fs-5">Tour number: </span>
        <input class="form-control w-25" type="number" name="tour_number" value="${obj.tour_number}">
    </p>
    <p>
        <span class="fs-5">Name: </span>
        <input class="form-control w-25" type="text" name="name" value="${obj.name}">
    </p>
    <p>
        <span class="fs-5">Start date: </span>
        <input class="form-control w-25" type="date" name="start_date" value="${obj.start_date}">
    </p>
    <p>
        <span class="fs-5">End date: </span>
        <input class="form-control w-25" type="date" name="end_date" value="${obj.end_date}">
    </p>
    <p>
        <span class="fs-5">Tour type: </span><br>
        <select class="form-select w-25" name="tour_type">
            <c:forEach var="item" items="${tour_types}">
                <option value="${item.id}">${item.tour_type}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <span class="fs-5">Country: </span><br>
        <select class="form-select w-25" name="country">
            <c:forEach var="item" items="${countries}">
                <option value="${item.id}">${item.country}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <span class="fs-5">Program: </span><br>
        <select class="form-select w-25" name="program_number">
            <c:forEach var="item" items="${programs}">
                <option value="${item.id}">${item.program_number}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <span class="fs-5">Status: </span><br>
        <select class="form-select w-25" name="status">
            <option value="Active">Active</option>
            <option value="Passive">Passive</option>
        </select>
    </p>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
<br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>
</body>
</html>
