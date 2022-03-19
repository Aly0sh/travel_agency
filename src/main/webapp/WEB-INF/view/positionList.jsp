<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>List</title>
</head>
<body>
<h2>All positions</h2>
<br>

<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="pos" items="${positions}">
        <tr>
            <td> ${pos.id}</td>
            <td> ${pos.position}</td>
            <td>
                <form:form action="update/${pos.id}">
                    <button type="submit" class="btn btn-warning">Edit</button></form:form>
            </td>
            <td>
                <form:form action="delete/${pos.id}"><button type="submit" class="btn btn-danger">Delete</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/lab5_war_exploded/position/add" class="btn btn-primary"> Add new Position</a>
<br> <br>
<a href="/lab5_war_exploded/" class="btn btn-danger">Home page</a>

</body>