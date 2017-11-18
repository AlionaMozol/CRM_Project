<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Netcufar | New Product</title>

    <script src="../../resources/js/new_product.js"></script>

</head>

<body>

    <%@include file="../layouts/preloader.jsp"%>
    <%@include file="../layouts/high_menu_bar.jsp"%>

    <div style="padding: 100px">
        <f:form method="post" commandName="product" action="/product/new-product/add/" acceptCharset="utf-8">
        <table>
            <tr>
                <td>
                    <i>Категория:</i>
                </td>
                <td>
                    <f:input path="superCategory"/>
                </td>
            </tr>
            <tr>
                <td>
                    <i>Тип:</i>
                </td>
                <td>
                    <f:input path="category"/>
                </td>
            </tr>

                <c:forEach  items="${product.attributesAndValues}" var="attributesAndValues" varStatus="status">
                    <tr>
                        <td>${attributesAndValues.key}</td>
                        <td><input name="attributesAndValues['${attributesAndValues.key}']" value="${attributesAndValues.value}"></td>
                    </tr>
                </c:forEach>

            <tr>

            </tr>
            <tr>
                <td><input type="submit"/></td>
            </tr>
        </table>
        </f:form>
    </div>

</body>