<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: evgeniy
  Date: 24.03.2022
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все сотрудники</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/><%--в эту ссылку мы добавдяем id работника (тоесть при обнавлении нужен id)--%>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/> <%-- updateButton это из строки 24--%>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/> <%-- из строки 27--%>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<%-- addNewEmployee - это имя url метода addNewEmployee в контроллере --%>
<input type="button" value="Add"
       onclick="window.location.href = 'addNewEmployee'"/>
</body>
</html>
