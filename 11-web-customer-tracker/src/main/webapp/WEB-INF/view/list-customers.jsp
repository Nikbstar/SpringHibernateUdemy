<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <h2 class="text-center">CRM - Customer Relationship Manager</h2>
    <br />
    <input class="btn btn-success" type="button" value="Add customer" onclick="window.location.href='showAddForm'; return false;" />
    <br />
    <br />
    <form:form action="search" method="get">
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Search..." aria-label="Search customers" aria-describedby="basic-addon2" name="searchParam">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="submit">Search</button>
            </div>
        </div>
    </form:form>
    <br />
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
            <th>First name</th>
            <th>Last name</th>
            <th>E-mail</th>
            <th>Action</th>
            </thead>
            <c:forEach var="tmpCustomer" items="${customers}">
                <tr>
                    <c:url var="updateLink" value="/customer/showUpdateForm">
                        <c:param name="customerId" value="${tmpCustomer.id}" />
                    </c:url>
                    <c:url var="deleteLink" value="/customer/deleteCustomer">
                        <c:param name="customerId" value="${tmpCustomer.id}" />
                    </c:url>
                    <td>${tmpCustomer.firstName}</td>
                    <td>${tmpCustomer.lastName}</td>
                    <td>${tmpCustomer.email}</td>
                    <td><a class="btn btn-primary" href="${updateLink}" role="button">Update</a>
                        <a onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" class="btn btn-danger" href="${deleteLink}" role="button">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
