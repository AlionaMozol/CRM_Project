<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Список товаров</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/catalog.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>


<div class="container content">
    <div class="col-lg-10 products">
        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="product">
                <div class="product-img">
                    <a href="#"><img src="${contextPath}/resources/img/moda2.jpg" alt=""></a>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <a href="#" class="button-heart">
                                <span class="icon icon-heart">
                                    <img src="${contextPath}/resources/img/heart.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <p class="product-title">
                    <a href="#"><strong>Чёрный женский костюм</strong></a>
                </p>
                <p class="product-desc">Модный костюм</p>
                <p class="product-category">Женская одежда</p>
                <p class="product-price">100$</p>
            </div>
        </div>

    </div>

</div>

<!--
<header>
    <div class="layout-buttons">
        <span class="active icon icon-list">
            list
        </span>
        <span class="icon icon-table">
            table
        </span>
    </div>
    <h1>"Список товаров"</h1>
    <div class="category">"Все категории"</div>
</header>

<div class="container content">
    <div class="col-lg-10 products">
        <div class="col-sm-4 product-wrapper">
            <a href="" class="product">
                <div class="product-main">
                    <div class="product-img">
                        <img src="${contextPath}/resources/img/moda2.jpg" alt="">
                    </div>
                    <div class="product-text">
                        <h2 class="product-name">
                            Куртка мужская чёрная
                        </h2>
                        <p class="product-desc">
                            "Отличная куртка, каждому к лицу и на любую погоду."
                        </p>
                    </div>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <span class="icon icon-heart">

                            </span>
                            <span class="product-icon-text">
                                В избранное
                            </span>
                        </div>
                    </div>
                </div>

                <div class="product-details">
                    <div class="product-category">
                        Мужская одежда
                    </div>
                    <div class="product-region">
                        Минская область, Минск
                    </div>
                    <span class="product-price">
                        <strong>10</strong>
                        <small>BYN</small>
                    </span>
                </div>
            </a>
        </div>

        <div class="col-sm-4 product-wrapper">
            <a href="" class="product">
                <div class="product-main">
                    <div class="product-img">
                        <img src="${contextPath}/resources/img/moda2.jpg" alt="">
                    </div>
                    <div class="product-text">
                        <h2 class="product-name">
                            Куртка мужская чёрная
                        </h2>
                        <p class="product-desc">
                            "Отличная куртка, каждому к лицу и на любую погоду."
                        </p>
                    </div>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <span class="icon icon-heart">

                            </span>
                            <span class="product-icon-text">
                                В избранное
                            </span>
                        </div>
                    </div>
                </div>

                <div class="product-details">
                    <div class="product-category">
                        Мужская одежда
                    </div>
                    <div class="product-region">
                        Минская область, Минск
                    </div>
                    <span class="product-price">
                        <strong>10</strong>
                        <small>BYN</small>
                    </span>
                </div>
            </a>
        </div>


        <div class="col-sm-4 product-wrapper">
            <a href="" class="product">
                <div class="product-main">
                    <div class="product-img">
                        <img src="${contextPath}/resources/img/moda2.jpg" alt="">
                    </div>
                    <div class="product-text">
                        <h2 class="product-name">
                            Куртка мужская чёрная
                        </h2>
                        <p class="product-desc">
                            "Отличная куртка, каждому к лицу и на любую погоду."
                        </p>
                    </div>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <span class="icon icon-heart">

                            </span>
                            <span class="product-icon-text">
                                В избранное
                            </span>
                        </div>
                    </div>
                </div>

                <div class="product-details">
                    <div class="product-category">
                        Мужская одежда
                    </div>
                    <div class="product-region">
                        Минская область, Минск
                    </div>
                    <span class="product-price">
                        <strong>10</strong>
                        <small>BYN</small>
                    </span>
                </div>
            </a>
        </div>

        <div class="col-sm-4 product-wrapper">
            <a href="" class="product">
                <div class="product-main">
                    <div class="product-img">
                        <img src="${contextPath}/resources/img/moda2.jpg" alt="">
                    </div>
                    <div class="product-text">
                        <h2 class="product-name">
                            Куртка мужская чёрная
                        </h2>
                        <p class="product-desc">
                            "Отличная куртка, каждому к лицу и на любую погоду."
                        </p>
                    </div>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <span class="icon icon-heart">

                            </span>
                            <span class="product-icon-text">
                                В избранное
                            </span>
                        </div>
                    </div>
                </div>

                <div class="product-details">
                    <div class="product-category">
                        Мужская одежда
                    </div>
                    <div class="product-region">
                        Минская область, Минск
                    </div>
                    <span class="product-price">
                        <strong>10</strong>
                        <small>BYN</small>
                    </span>
                </div>
            </a>
        </div>

        <div class="col-sm-4 product-wrapper">
            <a href="" class="product">
                <div class="product-main">
                    <div class="product-img">
                        <img src="${contextPath}/resources/img/moda2.jpg" alt="">
                    </div>
                    <div class="product-text">
                        <h2 class="product-name">
                            Куртка мужская чёрная
                        </h2>
                        <p class="product-desc">
                            "Отличная куртка, каждому к лицу и на любую погоду."
                        </p>
                    </div>
                    <div class="product-icons">
                        <div class="product-icons-item">
                            <span class="icon icon-heart">

                            </span>
                            <span class="product-icon-text">
                                В избранное
                            </span>
                        </div>
                    </div>
                </div>

                <div class="product-details">
                    <div class="product-category">
                        Мужская одежда
                    </div>
                    <div class="product-region">
                        Минская область, Минск
                    </div>
                    <span class="product-price">
                        <strong>10</strong>
                        <small>BYN</small>
                    </span>
                </div>
            </a>
        </div>
    </div>

</div>
 -->

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
