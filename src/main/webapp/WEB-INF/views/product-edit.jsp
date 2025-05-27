<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 27/05/2025
  Time: 5:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Product edit</h4>
<form:form modelAttribute="product" action="${pageContext.request.contextPath}/products/edit/${product.productId}" method="post">
    <table>
        <tr>
            <td>Product Name:</td>
            <td><form:input path="productName" /></td>
            <td><form:errors path="productName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:textarea path="description" /></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><form:input path="price" type="number" step="0.01"/></td>
            <td><form:errors path="price" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Image URL:</td>
            <td><form:input path="imageUrl" /></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td>
                <form:select path="status">
                    <form:option value="true">Active</form:option>
                    <form:option value="false">Inactive</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Category:</td>
            <td><form:select path="categoryId">
                <!-- Assuming categories is a list of Category objects available in the model -->
                <c:forEach var="category" items="${categories}">
                    <form:option value="${category.categoryId}">${category.categoryName}</form:option>
                </c:forEach>
            </form:select></td>
        </tr>
    </table>

    <button type="submit">Update Product</button>
    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/products'">Back to Product List</button>
</body>
</html>
