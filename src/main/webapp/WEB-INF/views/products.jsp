<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Shop</title>
    <link rel="stylesheet"  href="../../resources/css/main.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.min.css">


</head>


<body>

<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>

<div style="padding: 100px">
    <h1>Products</h1>
    <table style="border-style: solid">
        <tr>
            <td>    Ид     </td>
            <td>  ТопКатегория</td>
            <td>    Категория   </td>
            <td>Другие атррибуты</td>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><a href="${contextPath}/product/${product.id}">${product.id}</a> </td>
                <td>${product.superCategory}</td>
                <td>${product.category}</td>
                    <c:forEach items="${product.attributesAndValues}" var="value">
                        <td style="padding: 10px">
                        <option value="${product.attributesAndValues.key}">${product.attributesAndValues.value}</option>
                        </td>
                    </c:forEach>
                <td>${product.attributesAndValues}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="${contextPath}/product/new_product">New product</a>
</div>
</body>
