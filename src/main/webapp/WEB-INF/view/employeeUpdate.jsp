<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Update employee</h2>
<br>
<form action="/lab5_war_exploded/employee/do-update/${emp.id}">
    <p>
        <span class="fs-5">Passport id: </span>
        <input class="form-control w-25" type="number" value="${emp.passport_id}" name="passport_id">
    </p>
    <p>
        <span class="fs-5">Name: </span>
        <input class="form-control w-25" type="text" name="name" value="${emp.name}">
    </p>
    <p>
        <span class="fs-5">Address: </span>
        <input class="form-control w-25" type="text" name="address" value="${emp.address}">
    </p>
    <p>
        <span class="fs-5">Position: </span><br>
        <select class="form-select w-25" name="position">
            <c:forEach var="pos" items="${positions}">
                <option value="${pos.id}">${pos.position}</option>
            </c:forEach>
        </select>
    </p>
    <br>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
<br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>

</body>
</html>
