<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
        <div class="row wrapper-for-product">
            <div class="col-lg-4 product-img-1">
                <h2>Nazvanie</h2>
                <div class="wrapper-for-img">
                <img src="${contextPath}/resources/img/placeholder-image.png">
                </div>
            </div>
            <div class="col-lg-6 description-of-the-product">
                <p class="name-of-product">Haracteristiki</p>
                <div class="wrapper-for-ul">
                    <ul>
                    <c:forEach items="${productid.attributesAndValues}" var="value">
                        <li><spring:message code="${value.key}"/> :</li>

                    </c:forEach>
                    </ul>
                <ul>
                    <c:forEach items="${productid.attributesAndValues}" var="value">
                    <li>${value.value}</li>

                    </c:forEach>
                </ul>

                </div>
                <p class="description"> Description: ${productid.description}</p>

            </div>
        </div>

        <%@include file="../layouts/comment_layout.jsp"%>


        <sec:authorize access="hasRole('ROLE_USER')">
        <f:form method="POST" commandName="comment" action="/comment_layout" acceptCharset="utf-8">

        <p>Комментарий<Br>
                <f:textarea path="text" cols="40" rows="3"/>
                <f:input type="hidden" name="username" path="username" value="${pageContext.request.userPrincipal.name}"/>
                <f:input path="postId" type="hidden" name="postID" value="${productid.id}"/>
        <p><input type="submit" value="Отправить">
            </f:form>

        </sec:authorize>
    </div>


</body>