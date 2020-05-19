<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Company Home Page</title>
</head>
<body>
<h2>Welcome to the my company home page</h2>
<form:form method="post" action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="Logout" />
</form:form>
</body>
</html>
