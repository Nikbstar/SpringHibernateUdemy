<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Login Page</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
<h3>My Custom Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <c:if test="${param.error != null}">
        <i class="failed">Sorry! You entered invalid user name/password!</i>
        <br />
    </c:if>
    <c:if test="${param.error == null}">
        <br />
    </c:if>
    <label>User name:
        <input type="text" name="username" />
    </label>
    <br />
    <label>Password:
        <input type="password" name="password">
    </label>
    <br />
    <input type="submit" value="Login" />
</form:form>
</body>
</html>
