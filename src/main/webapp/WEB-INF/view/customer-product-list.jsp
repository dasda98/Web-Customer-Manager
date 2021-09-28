<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Product List</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</head>
<body>
<div>
    <jsp:include page="navbar.jsp" />
</div>
<div class="container">
    <div class="row">
        <div class="col-3">
            <ul class="list-group">
                <li class="list-group-item">${customer.firstName}</li>
                <li class="list-group-item">${customer.lastName}</li>
                <li class="list-group-item">${customer.email}</li>
            </ul>
        </div>
        <div class="col-sm">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Price ($)</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="${0}" />
                    <c:forEach var="tmpCustomer" items="${customer.productList}">
                        <c:set var="total" value="${total + tmpCustomer.price}" />
                        <tr>
                            <td>${tmpCustomer.name}</td>
                            <td>${tmpCustomer.price}</td>
                        </tr>
                    </c:forEach>
                <tr>
                    <td><strong>TOTAL</strong></td>
                    <td><c:out value="${total}" /></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
