<%--
  Created by IntelliJ IDEA.
  User: Mikhail
  Date: 29.10.17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<body>

<div class="navbar navbar-left">
    <!-- Обычное содержимое панели -->
    <div class="panel-heading">Категории</div>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.2.1.min.js"%>
    </script>
    <!-- Групповой список -->
    <script type="text/javascript">
        <%@include file="/resources/js/LeftMenu_layout_ajax.js"%>
    </script>

    <div class="list-group" id="supercategories">
        <!--<a href="#" class="list-group-item">Смартфоны </a>
        <a href="#" class="list-group-item">Ноутбуки </a>
        <a href="#" class="list-group-item">Планшеты </a>
        <a href="#" class="list-group-item">Компьютеры </a>-->
    </div>
</div>

</body>
