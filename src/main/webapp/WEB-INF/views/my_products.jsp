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

    <div class="container content">
        <a class="btn btn-success" href="${contextPath}/new_product" role="button">Добавить объявление</a>
        <div class="col-lg-9 products">

            <c:forEach items="${products}" var="product">

                <div class="col-sm-4">
                    <div class="product">
                        <div class="product-img">
                            <a href="#"><img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${product.photo}"></a>
                        </div>

                        <p class="product-title">
                            <a href="${contextPath}/product/${product.id}"><strong>${product.title}</strong></a>
                        </p>

                        <p class="product-desc">${product.description}</p>
                        <p class="product-category"><spring:message code="${product.category}"/></p>
                        <p class="product-price">${product.cost}</p>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>

</body>