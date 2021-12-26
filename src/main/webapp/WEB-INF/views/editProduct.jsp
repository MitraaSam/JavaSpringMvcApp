<%--
  Created by IntelliJ IDEA.
  User: sam_m
  Date: 11/9/2021
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<style>
    #main{
        width:910px;
        height:620px;
        margin:30px auto
    }
    form-add {
        background-color: #fff;
        max-width: 500px;
        margin: 50px auto;
        padding: 30px 20px;
        box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
        align-content: center;
    }

</style>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>
            <p class="lead">Please update the product information here :</p>
        </div>
        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct"  method="post"
                   modelAttribute="product"  enctype="multipart/form-data">
        <form:hidden path="productId" value="${product.productId}"/>
        <div class="form-group">
            <label for="name" style="font-size:16px;font-weight:bold">Name : </label>
            <form:input path="productName" id="name" class="form-contrl" style="width:70%" value="${product.productName}"/>

        </div>
        <br>
        <div class="form-group">
            <label for="category" style="font-size:16px;font-weight:bold">Category : </label>
            <label class="check-box" ><form:radiobutton path="productCategory" id="category"
                                                        value="instrument"/>Instrument</label>
            <label class="check-box" ><form:radiobutton path="productCategory" id="category"
                                                        value="record"/>Record</label>
            <label class="check-box" ><form:radiobutton path="productCategory" id="category"
                                                        value="accessory"/>Accessory</label>
        </div>
        <br>
        <div class="form-group">
            <label for="description" style="font-size:16px;font-weight:bold">Description : </label>
            <form:textarea path="productDescription" id="description" class="form-contrl" style="width:70%" value="${product.productDescription}"/>

        </div>
        <br>
        <div class="form-group">
            <label for="price" style="font-size:16px;font-weight:bold">Price : </label>
            <form:input path="productPrice" id="price" class="form-contrl" style="width:70%" value="${product.productPrice}"/>

        </div>
        <br>
        <div class="form-group" style="font-size:16px;font-weight:bold">
            <label for="condition">Condition : </label>
            <label class="check-box" ><form:radiobutton path="productCondition" id="condition"
                                                        value="new"/>New</label>
            <label class="check-box" ><form:radiobutton path="productCondition" id="condition"
                                                        value="used"/>Used</label>
        </div>
        <br>
        <div class="form-group">
            <label for="status" style="font-size:16px;font-weight:bold">Status : </label>
            <label class="check-box" ><form:radiobutton path="productStatus" id="status"
                                                        value="activ"/>Active</label>
            <label class="check-box" ><form:radiobutton path="productStatus" id="status"
                                                        value="inactive"/>Inactive</label>
        </div>
        <br>
        <div class="form-group">
            <label for="unitInStock" style="font-size:16px;font-weight:bold">Unit In Stock : </label>
            <form:input path="unitStock" id="unitInStock" class="form-contrl" style="width:70%" value="${product.unitStock}"/>

        </div>
        <br>
        <div class="form-group">
            <label for="manufacturer" style="font-size:16px;font-weight:bold">Manufacturer : </label>
            <form:input path="productManufacturer" id="manufacturer"  style="width:70%" class="form-contrl" value="${product.productManufacturer}"/>

        </div>
        <br>
        <div class="form-group">
            <label class="control-label" for="productImage" style="font-size:16px;font-weight:bold">Upload Picture : </label>
            <form:input path="productImage" id="productImage" class="form:input-large" style="width:70%" type="file" value="${product.productImage}"/>

        </div>
        <br><br>
        <input type="submit" value="submit" class="btn btn-secondary">
        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-secondary">Cancel</a>
        </form:form>

        <%@include file="/WEB-INF/views/template/footer.jsp"%>
