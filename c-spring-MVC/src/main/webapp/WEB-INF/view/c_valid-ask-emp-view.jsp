<%--
  Created by IntelliJ IDEA.
  User: evgeniy
  Date: 09.03.2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dear Employee, please enter your details</h2>
<br>
<br>
<form:form action="/empWithValid/showDetails" modelAttribute="employ">

    Name <form:input path="name"/>
    <form:errors path="name"/> <%--добавили для проверки поля--%>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    Department <form:select path="department">
        <form:options items="${employ.departments}"/>
    </form:select>
    <br><br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employ.carBrands}"/>
    <br><br>
    Foreign Language(s)
    <form:checkboxes path="languages" items="${employ.languageList}"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
