<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: evgeniy
  Date: 09.03.2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2> Deer Employee, you are welcome </h2>
<br>
<br>
<br>
Your name: ${employe.name} <%--получаем параметр из контроллера с именем nameAttribute--%>
<br>
Your surname: ${employe.surname}
<br>
Your salary: ${employe.salary}
<br>
Your department: ${employe.department}
<br>
Your carBrand: ${employe.carBrand}
<br>
Language(s):
<ul>
    <c:forEach var="lang" items="${employe.languages}">
        <li>${lang}</li>
    </c:forEach>
</ul>
</body>
</html>
