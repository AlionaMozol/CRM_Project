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

    <div style="padding: 100px">
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
    </div>

</body>