<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Список товаров</title>

    <link rel="stylesheet"  href="../../resources/css/main.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.min.css">
    <link href="${contextPath}/resources/css/catalog.css" rel="stylesheet">

</head>

<body>

<div class="container content">
    <div class="col-lg-10 products">

        <c:forEach items="${products}" var="product">

            <div class="col-sm-4">
                <div class="product">
                    <div class="product-img">
                        <a href="#"><img src="${contextPath}/resources/img/placeholder-image.png" alt=""></a>
                        <div class="product-icons">
                            <div class="product-icons-item">
                                <a href="#" class="icon">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </a>
                            </div>
                        </div>
                    </div>

                    <c:forEach items="${product.attributesAndValues}" var="title">
                        <c:if test="${title.key=='COST'}">
                            <p class="product-title">
                                <a href="#"><strong>${title.value}</strong></a>
                            </p>
                        </c:if>
                    </c:forEach>

                    <p class="product-desc">${product.description}</p>
                    <p class="product-category">${product.category}</p>
                    <c:forEach items="${product.attributesAndValues}" var="cost">
                        <c:if test="${cost.key=='COST'}">
                            <p class="product-price">${cost.value}</p>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

        </c:forEach>

    </div>
</div>

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>