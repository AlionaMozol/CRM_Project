<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Netcufar | Products</title>

</head>

<body>

<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>
<link href="${contextPath}/resources/css/catalog.css" rel="stylesheet">
<form:form class="content" method="post" commandName="User" acceptCharset="utf-8">
<div class="container content">
    <div class="col-lg-9 products">

        <c:forEach items="${profiles}" var="profiles">

            <div class="col-sm-4">
                <div class="product">
                    <div class="product-img">
                        <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${product.photo}"
                             onerror="this.src='${contextPath}/resources/img/placeholder-image.png'"/>
                    </div>

                    <p class="product-title">
                        <a href="${contextPath}/product/${profiles.id}"><strong>${profiles.fio}</strong></a>
                    </p>
                    <p class="product-category">${profiles.email}</p>
                    <div class="btn-group">
                        <c:if test="${profiles.status.equals('BLOCKED')}">
                            <button type="button" class="btn btn-primary btn-accept"><spring:message
                                    code="profileButtonUnblocked"/></button>
                        </c:if>
                        <c:if test="${profiles.status.equals('UNBLOCKED')}">
                            <button type="button" class="btn btn-primary btn-accept"><spring:message
                                    code="profileButtonBlocked"/></button>
                        </c:if>
                    </div>
                </div>
            </div>

        </c:forEach>

    </div>
</div>
</form:form>
</body>