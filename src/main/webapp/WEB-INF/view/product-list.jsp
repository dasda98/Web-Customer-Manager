<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product List</title>

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
                    value="Add Product"
                    onclick="window.location.href='showFormForAdd'; return false;"
            >Add Product</button>
            <form:form action="search" method="GET">
                Search product: <input type="text" name="searchName" />

                <button class="btn btn-secondary" value="Search" type="submit">Search</button>
            </form:form>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Price ($)</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tmpProduct" items="${productList}">
                <c:url var="updateLink" value="/product/showFormForUpdate">
                    <c:param name="productId" value="${tmpProduct.id}" />
                </c:url>
                <c:url var="deleteLink" value="/product/delete">
                    <c:param name="productId" value="${tmpProduct.id}" />
                </c:url>
                <tr>
                    <td>${tmpProduct.name}</td>
                    <td>${tmpProduct.price}</td>
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
