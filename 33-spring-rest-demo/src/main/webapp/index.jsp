<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring REST Demo</title>
</head>
<body>
Spring REST Demo
<hr />
<a href="${pageContext.request.contextPath}/test/hello">REST Hello world!</a>
<br />
<a href="${pageContext.request.contextPath}/api/students">REST get list of students.</a>
</body>
</html>
