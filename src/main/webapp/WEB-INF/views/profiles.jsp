<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link rel="stylesheet" media="screen" href="../../resources/css/profile.css">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/main.css" rel="stylesheet">

</head>


<body>

<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>

<div style="padding: 100px">
    <table style="border-style: solid">
            <div class = "container content">
                <div class="container">

                    <div class="row">
                        <div class="col-md-4 col-md-offset-3">
                            <f:form method="post" commandName="User" acceptCharset="utf-8">

                                <h3>ФИО</h3>
                                <div class="form-group">
                                        <f:input path="fio"/>
                                </div>
                                <h3>Город</h3>
                                <div class="form-group">
                                    <f:input path="city"/>
                                </div>
                                <h3>Телефон</h3>
                                <div class="form-group">
                                    <f:input path="telephone"/>
                                </div>
                                <h3>Почта</h3>
                                <div class="form-group">
                                    <f:input path="email"/>
                                </div>
                                <h3>Дата рождения</h3>
                                <div class="form-group">
                                    <f:input path="dateOfBirth"/>
                                </div>
                                <h3>Пол</h3>
                                <div class="form-group">
                                    <f:input path="sex"/>
                                </div>

                                <input type="submit" value="Сохранить">

                            </f:form>
                        </div>
                    </div>
                </div>
            </div>
    </table>
</div>
</body>
