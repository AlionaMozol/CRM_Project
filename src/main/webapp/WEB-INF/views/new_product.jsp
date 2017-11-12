<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Shop</title>
    <link rel="stylesheet"  href="../../resources/css/main.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.min.css">
    <script src="../../resources/js/new_product.js"></script>


</head>


<body>

<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>

<div style="padding: 100px">
    <f:form method="post" commandName="product" action="/new-product/add/" acceptCharset="utf-8">
    <table>
        <tr>
            <td>
                <i>Amount:</i>
            </td>
            <td>
                <f:input path="superCategory"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Payer ID:</i>
            </td>
            <td>
                <f:input path="category"/>
            </td>
        </tr>
        <tr>

        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
    </f:form>
</div>
</body>

