<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title><spring:message code="PAGE_TITLE"/> <spring:message code="productbyid"/></title>

</head>

<body>

    <%@include file="../layouts/preloader.jsp"%>
    <%@include file="../layouts/high_menu_bar.jsp"%>
    <div class="container content">
        <div class="row wrapper-for-product">
            <div class="col-lg-4 product-img-1">
                <h2><strong>${productid.title}</strong></h2>
                <div class="wrapper-for-img">
                <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${productid.photo}"
                     onerror="this.src='${contextPath}/resources/img/placeholder-image.png'">
                </div>
            </div>
            <div class="col-lg-6 description-of-the-product">
                <p class="name-of-product">
                    <strong><spring:message code="product.characteristics"/></strong>
                </p>
                <div class="wrapper-for-ul">
                    <ul>
                    <c:forEach items="${productid.attributesAndValues}" var="value">
                        <li><strong><spring:message code="${value.key}"/> :</strong></li>

                    </c:forEach>
                    </ul>
                <ul>
                    <c:forEach items="${productid.attributesAndValues}" var="value">
                    <li>${value.value}</li>

                    </c:forEach>
                </ul>

                </div>
                <p class="description"> <strong><spring:message code="product.cost"/>:</strong> ${productid.cost}</p>
                <p class="description"> <strong><spring:message code="product.description"/>:</strong> ${productid.description}</p>

            </div>
        </div>

        <%@include file="../layouts/comment_layout.jsp"%>


    </div>


</body>