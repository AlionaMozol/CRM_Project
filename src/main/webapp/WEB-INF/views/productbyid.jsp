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
                <h2>Nazvanie</h2>
                <div class="wrapper-for-img">
                <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${productid.photo}">
                </div>
            </div>
            <div class="col-lg-6 description-of-the-product">
                <p class="name-of-product"><spring:message code="product.characteristics"/></p>
                <div class="wrapper-for-ul">
                    <ul>
                    <c:forEach items="${productid.attributesAndValues}" var="value">
                        <li><spring:message code="${value.key}"/> :</li>

                    </c:forEach>
                    </ul>
                <ul>
                    <c:forEach items="${productid.attributesAndValues}" var="value">
                    <li>${value.value}</li>

                    </c:forEach>
                </ul>

                </div>
                <p class="description"> <spring:message code="product.cost"/>: ${productid.cost}</p>
                <p class="description"> <spring:message code="product.description"/>: ${productid.description}</p>

            </div>
        </div>

        <%@include file="../layouts/comment_layout.jsp"%>


    </div>


</body>