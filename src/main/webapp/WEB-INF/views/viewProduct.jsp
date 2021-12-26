<%@taglib prefix="form" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Here is the detail information of the product!! </p>
        </div>
        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                             width="500" height="500">
                </div>

            <div class="col-md-5">
                <h3>${product.productName}</h3>
                <p>${product.productDescription}</p>
                <p><strong>Manufacturer</strong>:${product.productManufacturer}</p>
                <p><strong>Category</strong>:${product.productCategory}</p>
                <p><strong>Condition</strong>:${product.productCategory}</p>
                <h4>${product.productPrice}usd</h4>

             <br>
                <c:set var="role" scope="page" value="${param.role}"/>
                <c:set var="url" scope="page" value="/productList"/>
                <c:if test="${role='admin'}">
                    <c:set var="url" scope="page" value="/admin/productInventory"/>
                </c:if>

                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}"/>" class="btn btn-outline-secondary">Back</a>
                    <a href="#" class="btn btn-warning btn-lg" ng-click="addToCart('${product.productId}')">
                        <i class="bi bi-cart3"></i> Order Now</a>
                    <a href="<spring:url value="/cart"/> " class="btn btn-outline-secondary">
                        <i class="bi bi-hand-index-thumb-fill"></i> View Cart</a>
                </p>
            </div>
        </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js"/> "></script>
        <%@include file="/WEB-INF/views/template/footer.jsp"%>
