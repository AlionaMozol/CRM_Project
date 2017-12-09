<%@ page contentType="text/html; charset=UTF-8"%>
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

    <link rel="stylesheet"  href="../../resources/css/main.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.min.css">
    <link href="${contextPath}/resources/css/catalog.css" rel="stylesheet">

</head>

<body>

<script type="text/JavaScript"
        src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js">
</script>

<div class="container content">
    <div class="col-lg-9 products">

        <c:forEach items="${products}" var="product">

            <div class="col-sm-4">
                <div class="product">
                    <div class="product-img">
                        <a href="#">
                            <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${product.photo}"
                                 onerror="this.src='${contextPath}/resources/img/placeholder-image.png'"/>
                        </a>
                        <sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')">
                            <div class="product-icons">
                                <div class="product-icons-item">
                                    <a id="${product.id}" class="icon">
                                        <img src="${contextPath}/resources/img/heart.png">
                                    </a>
                                </div>
                            </div>
                        </sec:authorize>
                    </div>

                    <p class="product-title">
                        <a href="${contextPath}/product/${product.id}"><strong>${product.title}</strong></a>
                    </p>

                    <p class="product-desc">${product.description}</p>
                    <p class="product-category"><spring:message code="${product.category}"/> </p>
                    <p class="product-price">${product.cost}</p>
                </div>
            </div>

        </c:forEach>

    </div>
</div>

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>

<script>
    $(document).on('click','.icon',function(event) {
        event.preventDefault();
        var productId = event.currentTarget.id;

        $.ajax({
            url : "/add-product-to-favorites",
            type : "GET",
            dataType : 'json',
            contentType : "application/json",
            data : ({
                productId : productId
            })
        });
    });

</script>