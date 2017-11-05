<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Shop</title>
    <link rel="stylesheet"  href="resources/css/main.css">
    <link rel="stylesheet"  href="resources/css/bootstrap.css">
    <link rel="stylesheet"  href="resources/css/bootstrap.min.css">
    <script src="http://bootstraptema.ru/_sf/3/394.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>


</head>


<body>

<%@include file="../layouts/high_menu_bar.jsp"%>
<%@include file="../layouts/product_list_layout.jsp"%>

</body>
