<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 27/05/2025
  Time: 3:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Category Edit</h4>
    <form:form modelAttribute="category" method="post" action="${pageContext.request.contextPath}/categories/edit/${category.categoryId}">
        <table>
            <tr>
                <td>Category Name:</td>
                <td><form:input path="categoryName" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:textarea path="description" /></td>
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
        </table>

        <button type="submit">Update Category</button>
        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/categories'">Back to Category List</button>
    </form:form>

</body>
</html>
