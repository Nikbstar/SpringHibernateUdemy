<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration</title>
    <style>
        .error {color: red}
    </style>
</head>
<body>
<i>Fill out the form. Asterisk (*) means required.</i>
<br />
<br />
<form:form action="processForm" modelAttribute="customer">
    <form:label path="firstName">First name:</form:label>
    <form:input path="firstName" />
    <br />
    <form:label path="lastName">Last name(*):</form:label>
    <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" />
    <br />
    <form:label path="freePasses">Free passes(*):</form:label>
    <form:input path="freePasses" />
    <form:errors path="freePasses" cssClass="error" />
    <br />
    <form:label path="postalCode">Postal code:</form:label>
    <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error" />
    <br />
    <form:label path="courseCode">Postal code:</form:label>
    <form:input path="courseCode" />
    <form:errors path="courseCode" cssClass="error" />
    <br />
    <input type="submit" value="Registration" />
</form:form>
</body>
</html>
