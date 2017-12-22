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

    <title><spring:message code="PAGE_TITLE"/> <spring:message code="profile"/></title>

    <link rel="stylesheet"  href="../../resources/css/main.css">
    <link rel="stylesheet"  href="../../resources/css/bootstrap.min.css">
    <link href="${contextPath}/resources/css/profile.css" rel="stylesheet">

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

</head>

<body >
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
                    $('#errEmail').empty();
                    $('#errEmail').append("This email already exist");
                    $('#email').css({'border': '1px solid #ff0000'});
                }
                else {
                    $('#errEmail').empty();
                    $('#errEmail').append(" ");
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
    $('#telephone').on("input", function () {
        var telephone = document.getElementById('telephone').value;
        $.ajax({
            url: '/checkTelephone',
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            data: {'telephone': telephone},
            success: function (data) {
                if (data.toString() == "-1") {
                    $('#errTelephone').empty();
                    $('#errTelephone').append("This telephone already exist");
                    $('#telephone').css({'border': '1px solid #ff0000'});
                }
                else {
                    $('#errTelephone').empty();
                    $('#errTelephone').append(" ");
                    var pattern = /^((80|\+375|375))(\(?\d{2}\)?)(\d{3}\-?)(\-?\d{2}\-?)(\-?\d{2})$/i;
                    if (pattern.test(telephone)) {
                        $('#telephone').css({'border': '1px solid #04f92d'});
                    }
                    else {
                        $('#telephone').css({'border': '1px solid #ff0000'});
                    }
                }
            }
        });
    });
})

</script>


<script type="text/javascript">
    $(document).ready(function() {
        if(${profiles.sex=='Ж'}) {
            $('#women').attr('checked',true);
        }
        else {
            $('#men').attr('checked',true);
        }
    })

</script>

<div class="content">
    <form:form method="post" action="${pageContext.request.contextPath}/profiles?${_csrf.parameterName}=${_csrf.token}" acceptCharset="utf-8" enctype="multipart/form-data">
        <div class="col-md-5 profile-img">

            <label class="btn btn-default col-md-6 col-md-offset-3">
                <div class="wrapper-for-img">
                    <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${profiles.photo}"
                         onerror="this.src='${contextPath}/resources/img/placeholder-image.png'"/>
                </div>
                File to upload: <input type="file" name="file"><br />
            </label>
        </div>
        <div class="col-md-5 ">
            <div class="form-group row has-feedback">
                <label class="col-2 col-form-label">ФИО</label>
                <div class="col-10">
                    <input id="fio" class="form-control" type="text" name="fio" value="${profiles.fio}"/>
                </div>
            </div>
            <div class="form-group row has-feedback">
                <label class="col-2 col-form-label">Email</label>
                <div class="col-10">
                    <input id="email" class="form-control" type="email" name="email" value="${profiles.email}"  />
                    <span id="errEmail" name="errEmail"></span>

                </div>
            </div>
            <div class="form-group row has-feedback">
                <label class="col-2 col-form-label">Телефон</label>
                <div class="col-10">
                    <input id="telephone" class="form-control" type="text" name="telephone" value="${profiles.telephone}"/>
                    <span id="errTelephone" name="errTelephone"></span>
                </div>
            </div>
            <div class="form-group row has-feedback">
                <label class="col-2 col-form-label">Город</label>
                <div class="col-10">
                    <input id="city" class="form-control" type="text" name="city" value="${profiles.city}"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-2 col-form-label">Дата рождения</label>
                <div class="col-10">
                    <input class="form-control" type="date" name="dateOfBirth" value="${profiles.dateOfBirth}"  max="2000-12-31" min="1900-01-01"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-2 col-form-label">Пол</label>
                <div class="col-10">

                    <input type="radio" name="sex"  id="men" value="М"/>Мужчина
                    <input type="radio" name="sex"  id="women" value="Ж"/>Женщина
                </div>
            </div>
            <button id="submit" type="submit" class="btn">Cохранить</button>
        </div>
    </form:form>
</div>



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
            var pattern = /^[а-яА-ЯёЁa-zA-Z\s-]{0,40}$/i;
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








