<%--
  Created by IntelliJ IDEA.
  User: Mikhail
  Date: 19.11.2017
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">



</head>
<body>
<div class="wrapper-for-comments">

    <c:forEach var="comment" items="${comments}">
        <div class="comment-in-product">

            <div class="image-of-user">
                <img src="${contextPath}/resources/img/placeholder-image.png">
            </div>
            <div class="text-in-user-comment">
                <p class="username">${comment.username}</p>
                <p class="comment">${comment.text}</p>
            </div>
        </div>

    </c:forEach>
</div>

</body>
</html>
