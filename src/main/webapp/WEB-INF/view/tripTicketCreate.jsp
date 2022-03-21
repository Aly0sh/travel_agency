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
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Create ${name}</h2>
<br>
<form action="/lab5_war_exploded/${url}/create">
    <p>
        <span class="fs-5">Event tickets: </span><br>
        <select class="form-select w-25" name="event_ticket">
            <c:forEach var="item" items="${eventTickets}">
                <option value="${item.id}">${item.place}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <span class="fs-5">Trip: </span><br>
        <select class="form-select w-25" name="trip">
            <c:forEach var="item" items="${trips}">
                <option value="${item.id}">${item.trip_number}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit" class="btn btn-primary">Create</button>
</form>
<br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>
</body>
</html>
