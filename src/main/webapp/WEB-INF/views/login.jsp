<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<link href="<c:url value="/resources/css/loginform.css"/>" rel="stylesheet">--%>
<div class="container-wrapper">

    <div class="container">

        <div class="login-box">
            <h2>Login with username and password</h2>
            <core:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </core:if>
            <form name="loginForm" action="<c:url value="/login"/>" method="post">
                <core:if test="${not empty error}">
                    <div class="error" style="color:red;">${error}</div>
                </core:if>
                <div class="form-group">
                    <label for="username" >User: </label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password" >Password: </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div><br>
                <input type="submit" value="Submit" class="btn btn-info" style="width:20%">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>

</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>