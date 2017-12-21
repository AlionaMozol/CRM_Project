<%--
  Created by IntelliJ IDEA.
  User: ThatGlance
  Date: 28.11.2017
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <%--<title>Модерация товаров</title>--%>

    <link rel="stylesheet" href="../../resources/css/main.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link href="${contextPath}/resources/css/catalog.css" rel="stylesheet">
</head>

<body>

<script type="text/JavaScript"
        src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js">
</script>

<div class="container content">
    <div class="col-lg-9 products">

        <c:forEach items="${nmod_products}" var="product">

            <div class="col-sm-4">
                <div class="product">
                    <div class="product-img">
                        <a href="#">
                            <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${product.photo}"
                                 onerror="this.src='${contextPath}/resources/img/placeholder-image.png'"/>
                        </a>
                    </div>
                    <p class="product-title-mod">
                        <a href="${contextPath}/product/${product.id}"><strong>${product.title}</strong></a>
                    </p>

                    <p class="product-desc">${product.description}</p>
                    <p class="product-category"><spring:message code="${product.category}"/></p>
                    <p class="product-price-mod">${product.cost}</p>

                    <div class="btn-group">
                        <button type="button" class="btn btn-primary btn-accept"><spring:message
                                code="moderationButtonAccept"/></button>
                        <button type="button" class="btn btn-primary btn-deny"><spring:message
                                code="moderationButtonDeny"/></button>
                    </div>
                </div>
            </div>

        </c:forEach>

    </div>
</div>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>

