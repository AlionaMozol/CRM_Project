<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Netcufar | Products By Id</title>

</head>

<body>

    <%@include file="../layouts/preloader.jsp"%>
    <%@include file="../layouts/high_menu_bar.jsp"%>
    <div class="container content">
        <div class="col-lg-10 products">


        <h1>Products</h1>
        <table style="border-style: solid">
            <tr>
                <td>ТопКатегория</td>
                <td>Категория</td>
                <td>Другие атррибуты</td>
            </tr>

                <tr>
                    <td>${productid.superCategory}</td>
                    <td>${productid.category}</td>



                    <td>${productid.attributesAndValues}</td>
                </tr>

        </table>
            <c:forEach var="comment" items="${comments}">
                <tr>

                    <td>${comment.id}</td>
                    <td>${comment.userId}</td>
                    <td>${comment.text}</td>
                </tr>
            </c:forEach>
    </div>
    </div>

</body>