<%--
  Created by IntelliJ IDEA.
  User: evgeniy
  Date: 09.03.2022
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- данную строчку необходимо добавить, когда начинаем работать с формами (form:form ) --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<form:form action="/showDetails" method="get"> <%--form action - связан с кнопкой submit, тут описываем что должно произойти при нажатии кнопки(переход по адресу /showDetails)--%>
    <input type="text" name="employeeName" <%-- type="text" - тип того, что будем вводить; name="employeeName" - имя поля формы(это имя будет хранить введенное значение)--%>
           placeholder="Write your name"/> <%--подсказка в самом поле--%>
    <input type="submit"/> <%--специальный тип, который отображает кнопку--%>
</form:form>
</body>
</html>
