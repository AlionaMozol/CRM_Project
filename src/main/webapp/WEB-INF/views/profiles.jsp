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

    <link rel="stylesheet"  href="../../resources/css/main.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.min.css">
    <link href="${contextPath}/resources/css/profile.css" rel="stylesheet">

</head>
user_roles
<body>
<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>

<script type="text/JavaScript"
        src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js">
</script>

<script type="text/javascript">$(document).on("input",function(ev) {
    $('#email').on("input", function () {
        var email = document.getElementById('email').value;
        $.ajax({
            url: '/checkEmail',
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            data: {'email': email},
            success: function (data) {
                if (data.toString() == "-1") {
                    $('#res').empty();
                    $('#res').append("This email already exist");
                    $('#email').css({'border': '1px solid #ff0000'});
                }
                else {
                    $('#res').empty();
                    $('#res').append(" ");
                    var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
                    if (pattern.test(email)) {
                        $('#email').css({'border': '1px solid #04f92d'});

                    }
                    else {
                        $('#email').css({'border': '1px solid #ff0000'});
                    }
                }
            }
        });
    });
})

</script>
<f:form class="content" method="post" commandName="User" acceptCharset="utf-8">
    <div class="col-md-5 profile-img">
        <img src="${contextPath}/resources/img/placeholder-image.png" alt="">
        <label class="btn btn-default col-md-6 col-md-offset-3">
            Выбрать фото <input type="file" name="file" hidden>
        </label>
    </div>
    <div class="col-md-5 ">
        <div class="form-group row has-feedback">
            <label class="col-2 col-form-label">ФИО</label>
            <div class="col-10">
                <f:input class="form-control" type="text" name="fio" path="fio"/>
                <form:errors path="fio"/>
            </div>
        </div>
        <div class="form-group row has-feedback">
            <label class="col-2 col-form-label">Email</label>
            <div class="col-10">
                <f:input id="email" class="form-control" type="email" name="email" path="email"  />
                <span id="res" name="res"></span>
                <form:errors path="email"/>

            </div>
        </div>
        <div class="form-group row has-feedback">
            <label class="col-2 col-form-label">Телефон</label>
            <div class="col-10">
                <f:input class="form-control" type="text" name="telephone" path="telephone"/>
                <form:errors path="telephone"/>
            </div>
        </div>
        <div class="form-group row has-feedback">
            <label class="col-2 col-form-label">Город</label>
            <div class="col-10">
                <f:input class="form-control" type="text" name="city" path="city"/>
                <form:errors path="city"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-2 col-form-label">Дата рождения</label>
            <div class="col-10">
                <f:input class="form-control" type="date" name="dateOfBirth" path="dateOfBirth"  max="2000-12-31" min="1900-01-01"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-2 col-form-label">Пол</label>
            <div class="col-10">
                <form:radiobutton path="sex" value="М"/>Мужчина
                <form:radiobutton path="sex" value="Ж"/>Женщина
            </div>
        </div>
        <button id="submit" type="submit" class="btn">Cохранить</button>
    </div>
</f:form>
<script type="text/javascript">$(document).on("input",function(ev) {


    $('#city').on("input",function() {
        if($(this).val() != '') {
            var pattern = /^[а-яА-ЯёЁa-zA-Z]{0,20}$/i;
            if(pattern.test($(this).val())){
                $(this).css({'border' : '1px solid #04f92d'});
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
            }
        }
    });
    $('#fio').on("input",function() {
        if($(this).val() != '') {
            var pattern = /^[а-яА-ЯёЁa-zA-Z\\s-]{0,40}$/i;
            if(pattern.test($(this).val())){
                $(this).css({'border' : '1px solid #04f92d'});
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
            }
        }
    });
    $('#telephone').on("input",function() {
        if($(this).val() != '') {
            var pattern = /^((80|\+375|375))(\(?\d{2}\)?)(\d{3}\-?)(\-?\d{2}\-?)(\-?\d{2})$/i;
            if(pattern.test($(this).val())){
                $(this).css({'border' : '1px solid #04f92d'});
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
            }
        }
    });
})
</script>
</body>








