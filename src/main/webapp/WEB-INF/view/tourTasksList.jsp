<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>List</title>
</head>
<body>
<h2>All ${name}</h2>
<br>

<table class="table">
    <tr>
        <th>Id</th>
        <th>Task number</th>
        <th>Passport id</th>
        <th>Tour number</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Program number</th>
        <th>Description</th>
        <th>Deadline</th>
        <th>Status</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="obj" items="${list}">
        <tr>
            <td> ${obj.id}</td>
            <td> ${obj.task_number}</td>
            <td> ${obj.passport_id}</td>
            <td> ${obj.tour_number}</td>
            <td> <fmt:formatDate value="${obj.start_date}" pattern="dd-MM-yyyy" /></td>
            <td> <fmt:formatDate value="${obj.end_date}" pattern="dd-MM-yyyy" /></td>
            <td> ${obj.program_number}</td>
            <td> ${obj.description}</td>
            <td> <fmt:formatDate value="${obj.deadline}" pattern="dd-MM-yyyy" /></td>
            <td> ${obj.status}</td>
            <td>
                <form:form action="update/${obj.id}">
                    <button type="submit" class="btn btn-warning">Edit</button></form:form>
            </td>
            <td>
                <form:form action="delete/${obj.id}"><button type="submit" class="btn btn-danger">Delete</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/lab5_war_exploded/${url}/add" class="btn btn-primary"> Add new ${name}</a>
<br> <br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>

</body>