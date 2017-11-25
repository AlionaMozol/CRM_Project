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

<script type="text/JavaScript"
        src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js">
</script>

<script type="text/javascript">
    function doAjax() {

        var inputText = "${productid.id}";

        $.ajax({
            url : '/getcomments',
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data : ({
                id: inputText
            }),
            success: function (data) {
                $.each(data, function(id, key){
                    var comment = "<div class=\"comment-in-product\">\n" +
                        "\n" +
                        "            <div class=\"image-of-user\">\n" +
                        "                <img src=\"${contextPath}/resources/img/placeholder-image.png\">\n" +
                        "            </div>\n" +
                        "            <div class=\"text-in-user-comment\">\n" +
                        "            <p class=\"username\">" + key.username + "</p>\n" +
                        "                <p class=\"comment\">" + key.text + "</p>\n" +
                        "            </div>\n" +
                        "        </div>";
                    $('.wrapper-for-comments').append(comment);
                })

            }


        });
    }
</script>

<script type="text/javascript"> doAjax() </script>






<<div class="wrapper-for-comments">




      <%--  <div class="comment-in-product">

            <div class="image-of-user">
                <img src="${contextPath}/resources/img/placeholder-image.png">
            </div>
            <div class="text-in-user-comment">
                <p class="username"></p>
                <p class="comment"></p>
            </div>
        </div>--%>
</div>

</body>

