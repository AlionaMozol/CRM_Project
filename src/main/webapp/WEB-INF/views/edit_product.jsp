<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Netcufar | Edit Product</title>

</head>
<body>


    <%@include file="../layouts/preloader.jsp"%>
    <%@include file="../layouts/high_menu_bar.jsp"%>

    <div style="padding: 100px">
        <f:form method="post" action="/product/edit/${ID}" acceptCharset="utf-8">
            <table>

                  <c:forEach  items="${IDProduct.attributesAndValues}" var="Values" varStatus="status">
                    <tr>
                        <td>${Values.key}</td>
                        <td><label>
                            <input name="attributesAndValues['${Values.key}']"
                                   value="${Values.value}">
                        </label></td>
                    </tr>
                </c:forEach>

                <tr>

                </tr>
                <tr>
                    <td><input type="submit" value="Изменить"/></td>
                </tr>
            </table>
        </f:form>
    </div>


    <%--<div class="container content">--%>
        <%--<div class="col-lg-10 products">--%>
            <%--<f:form method="post" commandName="product" action="/new-product/add/" acceptCharset="utf-8">--%>
            <%--<h1>Product</h1>--%>
            <%--<c:forEach items="${IDProduct.attributesAndValues}" var="value">--%>
                <%--<p><strong>${value.key}</strong></p>--%>
                <%--<p><input maxlength="25" size="40" value="${value.value}"></p>--%>
            <%--</c:forEach>--%>
            <%--</f:form>--%>
        <%--</div>--%>
    <%--</div>--%>


</body>
</html>
