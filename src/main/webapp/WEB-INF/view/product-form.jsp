<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Form</title>

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
    <form:form action="saveProduct" modelAttribute="product"  method="POST">
        <form:hidden path="id" />
        <div class="form-group">
            <label for="name">Name</label>
            <form:input type="text" class="form-control" id="name" path="name" placeholder="Enter name of product" />
            <form:errors path="name" cssClass="error" />
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <br>
            <input class="form-control" type="number" step="0.01" min="0" value="price" name="price" id="price" />
            <form:errors path="price" cssClass="error" />
        </div>
        <br>
        <button type="submit" class="btn btn-primary" value="Save">Submit</button>
    </form:form>
</div>
</body>
</html>
