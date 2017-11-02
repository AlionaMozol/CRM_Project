<%--
  Created by IntelliJ IDEA.
  User: Mikhail
  Date: 29.10.17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>



<body>

<div class="navbar navbar-left">
    <!-- Обычное содержимое панели -->
    <div class="panel-heading">Категории</div>

    <!-- Групповой список -->
    <div class="list-group">
        <a href="#" class="list-group-item">Смартфоны </a>
        <a href="#" class="list-group-item">Ноутбуки </a>
        <a href="#" class="list-group-item">Планшеты </a>
        <a href="#" class="list-group-item">Компьютеры </a>
    </div>
</div>

</body>
</html>
