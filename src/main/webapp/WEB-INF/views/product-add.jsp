<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi
  Date: 27/05/2025
  Time: 3:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add Product</h1>

<form:form modelAttribute="product" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/products/add">
    <table>
        <tr>
            <td>Product Name:</td>
            <td><form:input path="productName"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:textarea path="description"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><form:input path="price"/></td>
        </tr>
        <!-- org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver.logException Resolved [org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors<EOL>Field error in object 'product' on field 'imageUrl': rejected value [MultipartFile[field="imageUrl", filename=6b1e0ad53d5cc792f359d7aab823fb3b.jpg, contentType=image/jpeg, size=43566]]; codes [typeMismatch.product.imageUrl,typeMismatch.imageUrl,typeMismatch.java.lang.String,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.imageUrl,imageUrl]; arguments []; default message [imageUrl]]; default message [Failed to convert property value of type 'org.springframework.web.multipart.commons.CommonsMultipartFile' to required type 'java.lang.String' for property 'imageUrl'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'org.springframework.web.multipart.commons.CommonsMultipartFile' to required type 'java.lang.String' for property 'imageUrl': no matching editors or conversion strategy found]]
 -->
        <!--  private int productId;
    private String productName;
    private String description;
    private double price;
    private String imageUrl;
    private boolean status;
    private Date createDate;
    private int categoryId;
    private MultipartFile imageFile; -->

        <!-- Upload file -->
<%--        <tr>--%>
<%--            <td>Image URL:</td>--%>
<%--            <td><form:input path="imageUrl"/></td>--%>
<%--        </tr>--%>
        <tr>
            <td>Image:</td>
            <td><form:input type="file" path="imageFile"/></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td><form:select path="status">
                <form:option value="1">Active</form:option>
                <form:option value="0">Inactive</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td>Category ID:</td>
            <td><form:input path="categoryId"/></td>
        </tr>
    </table>

    <button type="submit">Add Product</button>
    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/products'">Back to Product List</button>
</form:form>
</body>
</html>
