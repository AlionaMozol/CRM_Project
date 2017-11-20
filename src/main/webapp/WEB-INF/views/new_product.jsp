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
        <f:form method="post" commandName="product" action="/new-product/add/" acceptCharset="utf-8">
        <table>
            <tr>
                <td>
                    <p><f:select path="superCategory">
                        <option disabled>Category</option>
                        <option value="Fashion">Fashion</option>
                        <option selected value="Animals">Animals</option>
                        <option value="Technics">Technics</option>
                        <option value="Realty">Realty</option>
                        <option value="Realty">House</option>
                        <option value="Auto">Auto</option>
                        <option value="Garden">Garden</option>
                    </f:select></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p><f:select path="category">
                        <option disabled>Type</option>
                        <option value="PHONES">PHONES</option>
                        <option selected value="TELEVISION">TELEVISION</option>
                        <option value="COMPUTERS">COMPUTERS</option>
                        <option value="OTHERS">OTHERS</option>
                    </f:select></p>
                </td>
            </tr>

                <c:forEach  items="${product.attributesAndValues}" var="attributesAndValues" varStatus="status">
                    <tr>
                        <td>${attributesAndValues.key}</td>
                        <td><label>
                            <input name="attributesAndValues['${attributesAndValues.key}']"
                                   value="${attributesAndValues.value}">
                        </label></td>
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