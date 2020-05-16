<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h2 class="text-center">CRM - Customer Relationship Manager</h2>
<h3 class="text-center">Edit customer</h3>

<form:form action="saveCustomer" modelAttribute="customer" method="post">
    <div class="container-fluid">
        <div class="form-group">
            <form:label path="firstName">First name:</form:label>
            <form:input path="firstName" cssClass="form-control" />
        </div>
        <div class="form-group">
            <form:label path="lastName">Last name:</form:label>
            <form:input path="lastName" cssClass="form-control" />
        </div>
        <div class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input path="email" cssClass="form-control" />
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <form:hidden path="id" />
        <button type="submit" class="btn btn-success">Save</button>
        <a class="btn btn-warning" href="list" role="button">Back to list</a>
    </div>
</form:form>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
