<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 27/05/2025
  Time: 2:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Product List</h1>

<button type="button" onclick="window.location.href='products/add'">Add Product</button>
<button type="button" onclick="window.location.href='/'">Back to Home</button>


<c:if test="${empty products}">
    <tr>
        <td colspan="7">No products available.</td>
    </tr>
</c:if>



<c:if test="${not empty products}">
    <table border="1">
    <tr>
        <th>STT</th>
        <th>Product Name</th>
        <th>Description </th>
        <th>Price </th>
        <th>Image </th>
        <th>Status </th>
        <th>Create Date </th>
        <th>Category </th>
        <th>Action</th>
    </tr>
    <!-- Empty product -->

    <c:forEach var="product" items="${products}" varStatus="loop">
        <tr>
            <td>
                    ${loop.index + 1}
            </td>
            <td>${product.productName}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td><img src="${product.imageUrl}" alt="Product Image" width="100"/></td>
            <td>${product.status}</td>
            <td>${product.createDate}</td>
            <td>${product.categoryId}</td>
            <td>
                <button type="button" onclick="window.location.href='products/edit/${product.productId}'">Edit</button>
                <button type="button" onclick="window.location.href='products/delete/${product.productId}'">Delete</button>
            </td>
        </tr>
    </c:forEach>


</table>

</c:if>



    </body>
</html>
