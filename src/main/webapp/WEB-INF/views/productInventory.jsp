<%--
  Created by IntelliJ IDEA.
  User: sam_m
  Date: 11/9/2021
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>
            <p class="lead">this is the product inventory page!</p>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo numb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>

            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                            width="80" height="80" ></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td>
                        <a href="<spring:url value="/productList/viewProduct/${product.productId}"/>"
                        ><i class="bi bi-exclamation-circle-fill"></i></a>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}"/>"
                        ><i class="bi bi-x"></i></a>
                        <a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}"/>"
                        ><i class="bi bi-pencil-fill"></i></a>
                    </td>
                </tr>
            </c:forEach>

        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct"/> " class="btn btn-primary">Add Product</a>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
