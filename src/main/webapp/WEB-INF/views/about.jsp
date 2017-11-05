<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
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

<div id="headewrap2">
    <div class= "container">
        <div class= "row">
            <div class="col-lg-8">



            </div>
        </div>
    </div>
</div>


<div class= "container">
    <div class="row centered">
        <div class="col-lg-6 col-lg-offset-2"></div>
        <h4>Компания Netcracker Technology – мировой лидер в области создания и внедрения комплексных BSS/OSS-решений для провайдеров услуг связи, крупных предприятий и государственных учреждений.
            Наши успехи в области предоставления решений и сервисов по управлению телекоммуникационными операциями признаны ведущими консалтинговыми компаниями и аналитическими агентствами, включая Gartner, Analysys Mason и Stratecast. Вместе с тем, компания Netcracker получила наивысшее признание от двух ведущих организаций по стандартизации в индустрии информационно-коммуникационных технологий - TM Forum и Университета Carnegie Mellon.  Благодаря обширным экспертным знаниям и многолетнему опыту разработки и внедрения решений Netcracker предоставляет большие возможности для профессионального развития и карьерного роста.</h4>

    </div>
</div>
<div class="futter">
    <div class="row centered">
        <div class="col-lg-8 col-lg-offset-2"></div>
        <h5>
            It's easy to buy!
        </h5>
    </div>
</div>



<div class="modal login" id="loginModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Login in</h4>
                <div class="box">
                    <form method="" action="" accept-charset="UTF-8">
                        <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                        <input id="password" class="form-control" type="password" placeholder="Password" name="password">
                        <input class="btn btn-default btn-login" type="button" value="Login" onclick="loginAjax()">
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">$(document).ready(function() {

    $('#email').blur(function() {
        if($(this).val() != '') {
            var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
            if(pattern.test($(this).val())){
                $(this).css({'border' : '1px solid #04f92d'});
                $('#valid').text('');
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
                $('#valid').text('Invalid emaiil');
            }
        } else {
            $(this).css({'border' : '1px solid #ff0000'});
            $('#valid').text('Поле email не должно быть пустым');
        }
    });
})
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>