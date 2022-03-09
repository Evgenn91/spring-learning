<%--
  Created by IntelliJ IDEA.
  User: evgeniy
  Date: 09.03.2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--это необходимо добавить, чтобы можно было использовать формы sprin mvc (form:form и form:input)--%>
<%@taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dear Employee, please enter your details</h2>
<br>
<br>
<%--сначала пишем форму, содержащую в себе другие формы тег form:form--%>
<form:form action="/employee/showDetails" modelAttribute="employee"> <%--acion - связан с кнопкой submit(при её нажатии перекинет на др адрес); modelAttribute="employee"- имя атрибута, котрый был создан в методе контроллера--%>
    <%--теперь напишем форму, предназначенную для текста(используется 1 строка)--%>
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <%--это можно задать в объекте Employee с помощбью Map, чтобы здесь не расписывать--%>
    Department <form:select path="department">
        <form:option value="Information Technology" label="IT"/>
        <form:option value="Human Resourses" label="HR"/>
        <form:option value="Sales" label="sales"/>
    </form:select>
    <br><br>
    Which car do you want?
    <%--также это можно задать в объекте с помощью Map, а не здесь расписывать(смотри в лекциях)--%>
    BMW <form:radiobutton path="carBrand" value="BMW"/>
    Audi <form:radiobutton path="carBrand" value="Audi"/>
    Mercedes <form:radiobutton path="carBrand" value="Mercedes Bens"/>
    <br><br>
    <%--также можно не прописывать в html, а cделать в Employee Map--%>
    Foreign Language(s)
    EN <form:checkbox path="languages" value="English"/>
    DE <form:checkbox path="languages" value="Deutch"/>
    FR <form:checkbox path="languages" value="French"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>