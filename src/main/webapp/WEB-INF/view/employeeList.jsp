<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>List</title>
</head>
<body>
<h2>All employees</h2>
<br>

<table class="table">
    <tr>
        <th>Id</th>
        <th>Passport id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Position</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td> ${emp.id}</td>
            <td> ${emp.passport_id}</td>
            <td> ${emp.name}</td>
            <td> ${emp.address}</td>
            <td> ${emp.position.getPosition()}</td>
            <td>
                <form:form action="update/${emp.id}">
                    <button type="submit" class="btn btn-warning">Edit</button></form:form>
            </td>
            <td>
                <form:form action="delete/${emp.id}"><button type="submit" class="btn btn-danger">Delete</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>


<a href="/lab5_war_exploded/employee/add" class="btn btn-primary"> Add new Employee</a>
<br> <br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>

</body>