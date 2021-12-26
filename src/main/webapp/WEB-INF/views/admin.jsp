<%@include file="/WEB-INF/views/template/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>
            <p class="lead">this is the Administrator page! </p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name !=null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name}  |  <a href="<c:url value="/login" />">Logout</a>
        </h2><br><br>
        </c:if>
        <h3>
            <a href="<c:url value="admin/productInventory" />">Product Inventory</a>
        </h3>
        <p>here you can view , check and notify the product inventory</p>


<%@include file="/WEB-INF/views/template/footer.jsp"%>