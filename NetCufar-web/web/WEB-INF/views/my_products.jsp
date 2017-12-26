<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title><spring:message code="PAGE_TITLE"/> <spring:message code="my_product"/></title>

</head>

<body>

    <%@include file="../layouts/preloader.jsp"%>
    <%@include file="../layouts/high_menu_bar.jsp"%>


    <div class="container content" style="margin-bottom: 20%">
        <a class="btn btn-success" href="${contextPath}/new_product" role="button" style="margin-bottom: 10px"><spring:message code="AddProduct"/></a>
        <div class="col-lg-12 products">

            <c:forEach items="${products}" var="product">

                <div class="col-sm-4">
                    <div class="product">
                        <div class="col-xs-12 text-left">
                            <a href="${contextPath}/product/edit/${product.id}">
                                <img src="${contextPath}/resources/img/pencil.png">
                            </a>
                        </div>


                        <div class="product-img">
                            <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${product.photo}"
                                 onerror="this.src='${contextPath}/resources/img/placeholder-image.png'"/>

                        </div>

                        <p class="product-title">
                            <a class="product-title" href="${contextPath}/product/${product.id}">
                                <strong>${product.title}</strong>
                            </a>
                        </p>

                        <p class="product-desc">${product.description}</p>
                        <p class="product-category"><spring:message code="${product.category}"/></p>
                        <p class="product-price">${product.cost}</p>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div>
    <%@include file="../layouts/footer_layout.jsp"%>

</body>