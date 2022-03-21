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
<h2>Update Room</h2>
<br>
<form action="/lab5_war_exploded/rooms/do-update/${obj.id}">
    <p>
        <span class="fs-5">Arrival date: </span>
        <input class="form-control w-25" type="date" name="arrival_date" value="${obj.arrival_date}">
    </p>
    <p>
        <span class="fs-5">Departure date: </span>
        <input class="form-control w-25" type="date" name="departure_date" value="${obj.departure_date}">
    </p>
    <p>
        <span class="fs-5">Place: </span>
        <input class="form-control w-25" type="number" name="place" value="${obj.place}">
    </p>
    <p>
        <span class="fs-5">Hotel: </span><br>
        <select class="form-select w-25" name="hotel">
            <c:forEach var="item" items="${hotels}">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <span class="fs-5">Category: </span><br>
        <select class="form-select w-25" name="category">
            <c:forEach var="item" items="${categories}">
                <option value="${item.id}">${item.category}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
<br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>
</body>
</html>
