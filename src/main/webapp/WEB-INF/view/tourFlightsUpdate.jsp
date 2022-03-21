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
        <span class="fs-5">Flight code: </span>
        <input class="form-control w-25" type="number" name="flight_code" value="${obj.flight_code}">
    </p>
    <p>
        <span class="fs-5">Air company: </span>
        <input class="form-control w-25" type="text" name="air_company" value="${obj.air_company}">
    </p>
    <p>
        <span class="fs-5">Departure date: </span>
        <input class="form-control w-25" type="date" name="departure_date" value="${obj.departure_date}">
    </p>
    <p>
        <span class="fs-5">Departure time: </span>
        <input class="form-control w-25" type="time" name="departure_time" value="${obj.departure_time}">
    </p>
    <p>
        <span class="fs-5">Arrival city: </span>
        <input class="form-control w-25" type="text" name="arrival_city" value="${obj.arrival_city}">
    </p>
    <p>
        <span class="fs-5">Departure city: </span>
        <input class="form-control w-25" type="text" name="departure_city" value="${obj.departure_city}">
    </p>
    <p>
        <span class="fs-5">Directions: </span>
        <input class="form-control w-25" type="text" name="directions" value="${obj.directions}">
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
