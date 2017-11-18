<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<body>

    <div class="navbar navbar-left">
        <!-- Обычное содержимое панели -->

        <!-- Групповой список -->
        <div class="list-group">
            <c:forEach var="category" items="${productCategory}">
                    <a href="#" class="list-group-item"> <spring:message code="${category.title}"/></a>
                <%--<c:forEach var="subcategory" items="${sessionScope.categoryJSP.categoryList}">
                    <a href="#" class="list-group-item"> ${subcategory.title}  </a>
                </c:forEach>--%>

            </c:forEach>
        </div>
    </div>

</body>