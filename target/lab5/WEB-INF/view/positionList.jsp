<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<h2>All positions</h2>
<br>

<table>
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
                    <button type="submit">Edit</button></form:form>
            </td>
            <td>
                <form:form action="delete/${pos.id}"><button type="submit">Delete</button></form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/lab5_war_exploded/position/add"> Add new Position</a>
</body>