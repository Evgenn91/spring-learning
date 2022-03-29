
<%--
  Created by IntelliJ IDEA.
  User: evgeniy
  Date: 28.03.2022
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>

<%-- отвечает за то, что каждая кнопка видна только тому, у кого определенные права --%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Information for all employees</h3>
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary"
       onclick="window.location.href = 'hr_info'"/>
Only for HR staff
</security:authorize>
<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance"
       onclick="window.location.href = 'manager_info'">
Only for managers
</security:authorize>
</body>
</html>
