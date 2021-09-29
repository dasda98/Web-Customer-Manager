<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Form</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div>
    <jsp:include page="navbar.jsp" />
</div>
<div class="container">
    <form:form action="saveCustomer" modelAttribute="customer"  method="POST">
        <form:hidden path="id" />
        <div class="form-group">
            <label for="firstName">First name</label>
            <form:input type="text" class="form-control" id="firstName" path="firstName" placeholder="Enter first name" />
            <form:errors path="firstName" cssClass="error" />
        </div>
        <div class="form-group">
            <label for="lastName">Last name</label>
            <form:input type="text" class="form-control" id="lastName" path="lastName" placeholder="Enter last name" />
            <form:errors path="lastName" cssClass="error" />
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input type="email" class="form-control" id="email" path="email" placeholder="Enter email" />
            <form:errors path="email" cssClass="error" />
        </div>
        <div>
            <br>
        </div>
        <div class="form-group">
            <label>List of Products</label>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Name</th>
                    <th scope="col">Price ($)</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="tmpProduct" items="${product}">
                    <tr>
                        <td><form:checkbox path="productList" value="${tmpProduct}"></form:checkbox></td>
                        <td>${tmpProduct.name}</td>
                        <td>${tmpProduct.price}</td>
                    </tr>
                    <form:errors path="productList" cssClass="error" />
                </c:forEach>
                </tbody>
            </table>
        </div>
        <button type="submit" class="btn btn-primary" value="Save">Submit</button>
    </form:form>
</div>
</body>
</html>
