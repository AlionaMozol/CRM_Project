<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/wrapper/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/wrapper/noJS.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/wrapper/style.css" rel="stylesheet">

    <link rel="stylesheet"  href="../../resources/css/main.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.min.css">

    <script src="../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../resources/js/drop-down.js"></script>

</head>

<body>

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href=""><spring:message code="headerShop"/></a>
                <a href="<%=request.getContextPath()%>?languageVar=en">EN</a>
                <a href="<%=request.getContextPath()%>?languageVar=ru">RU</a>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a class="navbar-text">
                        <spring:message code="headerWelcome"/>, ${pageContext.request.userPrincipal.name}
                    </a>
                </c:if>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                <div class="col-sm-4 col-md-5">
                            <form class="navbar-form" role="search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="<spring:message code="headerSearch"/>" name="q">
                                    <div class="input-group-btn">
                                        <button class="btn btn-default" type="submit">
                                            <i class="glyphicon glyphicon-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    <li><a class="wrapper-dropdown-5" href="${contextPath}/welcome"><spring:message code="headerStartPage"/></a></li>
                    <li><a href="${contextPath}/about"><spring:message code="headerAbout"/></a></li>
                    <li>
                        <div id="dd" class="wrapper-dropdown-5" tabindex="1"><spring:message code="headerAccount"/>
                            <ul class="dropdown">
                                <li><a href="${contextPath}/profiles"><i class="icon-user"></i><spring:message code="headerMenuProfile"/></a></li>
                                <li><a href="${contextPath}/account"><i class="icon-user"></i><spring:message code="headerAccount"/></a></li>
                                <li><a href="${contextPath}/products"><i class="icon-list"></i><spring:message code="headerMenuMyProducts"/></a></li>
                                <li><a href="${contextPath}/not_moderated"><i class="icon-list"></i><spring:message code="headerMenuProductModeration"/></a></li>
                                <li><a href="#"><i class="icon-cog"></i><spring:message code="headerMenuSettings"/></a></li>
                                <li>
                                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                                        <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        </form>
                                        <a class="btn btn-default" onclick="document.forms['logoutForm'].submit()"><spring:message code="headerMenuLogOut"/></a>
                                    </c:if>

                                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                                        <a class="btn btn-default" href="${contextPath}/login"><spring:message code="headerMenuLogOut"/></a>
                                    </c:if>
                                </li>

                            </ul>
                        </div>
                        <%--a onmouseover="down()"href="${contextPath}/profile">Profile</a--%>

                    </li>

                </ul>
            </div>
        </div>
    </div>

</body>