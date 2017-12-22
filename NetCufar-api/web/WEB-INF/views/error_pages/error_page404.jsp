<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>

<% response.setStatus(404); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404 error</title>
    </head>
    <body>
        <div class="col-xs-12" style="margin-top: auto; font-size: x-large; text-align: center; margin-top: 10%">
            <spring:message code="error404"/>
        </div>
        <div class="col-xs-12" style="margin-top: auto; font-size: x-large; text-align: center">
            <img src="../../resources/img/error.png" alt="" class="img-responsive">
        </div>
    </body>
</html>