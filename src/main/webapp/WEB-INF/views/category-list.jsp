<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 27/05/2025
  Time: 3:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<button type="button" onclick="window.location.href='categories/add'">Add Category</button>
<br>

<!-- redirect to "/" -->

<button type="button" onclick="window.location.href='/'">Back to Home</button>

<c:if test="${empty categories}">
    <tr>
        <td colspan="7">No categories available.</td>
    </tr>
</c:if>

<c:if test="${not empty categories}">
    <h1>Category List</h1>

    <table border="1">
        <tr>
            <th>STT</th>
            <th>Category Name</th>
            <th>Description</th>
            <th>Status</th>
            <th>Action</th>

        </tr>

        <c:forEach var="category" items="${categories}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${category.categoryName}</td>
                <td>${category.description}</td>
                <td>${category.status}</td>
                <td>
                    <button type="button" onclick="window.location.href='categories/edit/${category.categoryId}'">Edit</button>
                    <button type="button" onclick="window.location.href='categories/delete/${category.categoryId}'">Delete</button>
                </td>

            </tr>
        </c:forEach>

    </table>
</c:if>


</body>
</html>
