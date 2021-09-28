<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</head>
<body>
    <div>
        <jsp:include page="navbar.jsp" />
    </div>
    <div class="container">
        <div>
            <button class="btn btn-primary"
                    value="Add Customer"
                    onclick="window.location.href='showFormForAdd'; return false;"
            >Add Customer</button>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">Email</th>
                <th scope="col">Details</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tmpCustomer" items="${customerList}">
                <c:url var="productsLink" value="/customer/showProducts">
                    <c:param name="customerId" value="${tmpCustomer.id}" />
                </c:url>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tmpCustomer.id}" />
                </c:url>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tmpCustomer.id}" />
                </c:url>
                <tr>
                    <td>${tmpCustomer.firstName}</td>
                    <td>${tmpCustomer.lastName}</td>
                    <td>${tmpCustomer.email}</td>
                    <td> <a class="btn btn-info" role="button" href="${productsLink}">Products</a> </td>
                    <td>
                        <a class="btn btn-success" role="button" href="${updateLink}">Update</a>
                        <a class="btn btn-danger" role="button" href="${deleteLink}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
