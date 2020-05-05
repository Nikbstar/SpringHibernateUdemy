<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
<h2>Hello, ${student}</h2>
<p>Country: ${student.country}</p>
<p>Favorite language: ${student.favoriteLanguage}</p>
<ul>Operating systems:
    <c:forEach var="os" items="${student.operatingSystems}">
        <li>${os}</li>
    </c:forEach>
</ul>
</body>
</html>
