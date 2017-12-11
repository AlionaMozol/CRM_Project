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

    <title><spring:message code="PAGE_TITLE"/> <spring:message code="edit_product"/></title>

</head>
<body>


<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>

<div class="container content">
    <div class="row wrapper-for-product">
        <div class="col-lg-4 product-img-1">
            <h2>${IDProduct.title}</h2>
            <div class="wrapper-for-img">
                <img src="${contextPath}/resources/img/placeholder-image.png">
            </div>
        </div>
        <div class="col-lg-6 description-of-the-product">
            <p class="name-of-product"><spring:message code="product.characteristics"/></p>
            <f:form method="post" action="/product/edit/${ID}" acceptCharset="utf-8">

                <table class="row-distance">
                    <tr>
                        <td><spring:message code="PRODUCT_CREATE_DATE_TIME"/></td>
                        <td>${IDProduct.publicationDate}</td>
                    </tr>
                    <tr>
                        <td><spring:message code="PRODUCT_LAST_EDIT_DATE_TIME"/></td>
                        <td>${IDProduct.dateOfLastEdit}</td>
                    </tr>
                    <tr>
                        <td><spring:message code="STATUS"/></td>
                        <td>${IDProduct.productStatus}</td>
                    </tr>
                    <tr>
                        <td><spring:message code="TELEPHONE"/></td>
                        <td>${IDProduct.phone}</td>
                    </tr>
                    <tr>
                        <td><spring:message code="COST"/></td>
                        <td><input class="fill-whole-cell" name="attributesAndValues['COST']" value="${IDProduct.cost}"></td>
                    </tr>
                    <c:forEach  items="${IDProduct.attributesAndValues}" var="Values" varStatus="status">
                        <tr>
                            <td><spring:message code="${Values.key}"/></td>
                            <td><input class="fill-whole-cell" name="attributesAndValues['${Values.key}']" value="${Values.value}"></td>
                        </tr>

                    </c:forEach>

                    <tr>
                        <td colspan="2"><spring:message code="DESCRIPTION"/></td>
                    </tr>

                    <tr>
                        <td colspan="2" class="comment_edit_product">
                            <%--<input class="fill-whole-cell text-in-user-comment" name="attributesAndValues['DESCRIPTION']" value="${IDProduct.description}">--%>
                            <textarea class="fill-whole-cell" name="attributesAndValues['DESCRIPTION']">${IDProduct.description}</textarea>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" value="Изменить" class="fill-whole-cell"/></td>
                    </tr>
                </table>
            </f:form>
            <%--<f:form method="post" action="/product/edit/${ID}" acceptCharset="utf-8">--%>
                <%--<div class="wrapper-for-ul">--%>
                    <%--<div class="li-margin">--%>
                        <%--<ul>--%>

                            <%--<c:forEach  items="${IDProduct.attributesAndValues}" var="Values" varStatus="status">--%>
                                <%--<li>--%>
                                    <%--<spring:message code="${Values.key}"/>--%>
                                <%--</li>--%>
                            <%--</c:forEach>--%>


                        <%--</ul>--%>
                    <%--</div>--%>

                    <%--<div class="li-margin">--%>
                        <%--<ul>--%>
                            <%--<c:forEach  items="${IDProduct.attributesAndValues}" var="Values" varStatus="status">--%>
                                <%--<li>--%>
                                    <%--<input name="attributesAndValues['${Values.key}']" value="${Values.value}">--%>
                                <%--</li>--%>
                            <%--</c:forEach>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<input type="submit" value="Изменить"/>--%>
            <%--</f:form>--%>
        </div>
    </div>

</div>

</body>
</html>