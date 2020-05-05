<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    <form:label path="firstName">First name:</form:label>
    <form:input path="firstName" />
    <br />
    <form:label path="lastName">Last name:</form:label>
    <form:input path="lastName" />
    <br />
    <form:label path="country">Country:</form:label>
    <form:select path="country">
        <form:options items="${countriesList}" />
    </form:select>
    <br />
    <form:label path="favoriteLanguage">Favorite language:</form:label>
    <form:radiobuttons path="favoriteLanguage" items="${favoriteLanguageList}" />
    <br />
    <form:label path="operatingSystems">Operating systems:</form:label>
    <form:checkbox path="operatingSystems" value="MS Windows" label="MS Windows" />
    <form:checkbox path="operatingSystems" value="Linux" label="Linux" />
    <form:checkbox path="operatingSystems" value="MAC OS" label="MAC OS" />
    <br />
    <input type="submit" value="Registration" />
</form:form>
</body>
</html>
