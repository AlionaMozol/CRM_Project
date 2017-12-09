<%--
  Created by IntelliJ IDEA.
  User: ThatGlance
  Date: 19.11.2017
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Product moderation</title>

    <%--
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="${contextPath}/resources/css/catalog.css" rel="stylesheet">
    <link rel="stylesheet"  href="../../resources/css/main.css">
    --%>
</head>

<body>
    <%@include file="../layouts/preloader.jsp"%>
    <%@include file="../layouts/high_menu_bar.jsp"%>
    <%@include file="../layouts/left_menu_layout.jsp"%>
    <%@include file="../layouts/moderation_layout.jsp"%>
    <%--<div class="container content">
        <div class="col-lg-9 products">

            <c:forEach items="${products}" var="product">

                <div class="col-sm-4">
                    <div class="product">
                        <div class="product-img">
                            <a href="#"><img src="${contextPath}/resources/img/placeholder-image.png" alt=""></a>
                        </div>
                        <p class="product-title-mod">
                            <a href="${contextPath}/product/${product.id}"><strong>${product.id}</strong></a>
                        </p>

                        <p class="product-desc">${product.description}</p>
                        <p class="product-category">${product.category}</p>
                        <p class="product-price-mod">${product.cost}</p>

                        <div class="btn-group">
                            <button type="button" class="btn btn-primary btn-accept"><spring:message code="moderationButtonAccept"/></button>
                            <button type="button" class="btn btn-primary btn-deny"><spring:message code="moderationButtonDeny"/></button>
                        </div>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>--%>
    <%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
--%>
</body>