<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title><spring:message code="PAGE_TITLE"/> <spring:message code="new_product"/></title>

</head>

<body>

<%@include file="../layouts/preloader.jsp" %>
<%@include file="../layouts/high_menu_bar.jsp" %>
<script type="text/JavaScript"
        src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js">
</script>

<script type="text/javascript">
    var messages = [];
    <c:forEach var="key" items="${keys}">
    messages["<spring:message text="${key}" javaScriptEscape="true"/>"] = "<spring:message code='${key}' javaScriptEscape='true' />";
    </c:forEach>

    function showAttributes() {
        $.ajax({
            type: 'GET',
            url: "/attributes",
            dataType: 'json',
            data: {
                subCategory: $('#select_sub_category').val()
            },
            success: function (data) {
                $('#submit-button').show();
                $('#wrapper-for-attributes').empty();


                $.each(data, function (index, value) {
                    var newInput = (
                        "<div class='form-group row has-feedback'>" +
                        "<label class='label-attribute'> " +
                        messages[value] +
                        "</label>" +
                        "<input class=\"form-control\" name=" + value + " placeholder=" + messages[value] + "></div>");
                    $('#wrapper-for-attributes').append(newInput);
                })
            },
            error: function () {
                alert('Error');
            }

        })
    }

    function showSubCategories() {
        $.ajax({
            type: 'GET',
            url: "/categories",
            dataType: 'json',
            data: {
                topCategory: $('#select_top_category').val()
            },

            success: function (data) {
                $('#submit-button').hide();
                $('#select_sub_category').empty();
                $.each(data, function (index, value) {
                    var newOption = ("<option value=" + value.title + ">" + messages[value.title] + "</option>");
                    $('#select_sub_category').append(newOption);
                });
                showAttributes();
            },
            error: function () {
                alert('Hello');
            }
        });

    }

    $(document).ready(function () {
        $('#new-product').submit(function () {
            if ($('#title').val() !== '' &&
                $('#cost').val() !== '') {
                var patternTitle = /^[0-9а-яА-ЯёЁa-zA-Z\s-]{1,70}$/i;
                var patternCost = /^([1-9]+([0-9]+)?){0,40}$/i;
                return patternTitle.test($('#title').val()) &&
                    patternCost.test($('#cost').val());
            } else {
                return false;
            }
        });


        $('#title').on("input", function () {
            if ($(this).val() !== '') {
                var pattern = /^[0-9а-яА-ЯёЁa-zA-Z\s-]{1,70}$/i;
                if (pattern.test($(this).val())) {
                    $(this).css({'border': '1px solid #04f92d'});
                } else {
                    $(this).css({'border': '1px solid #ff0000'});
                }
            } else {
                $(this).css({'border': '1px solid #ff0000'});
            }
        });

        $('#cost').on("input", function () {
            if ($(this).val() != '') {
                var pattern = /^([1-9]+([0-9]+)?){0,40}$/i;
                if (pattern.test($(this).val())) {
                    $(this).css({'border': '1px solid #04f92d'});
                } else {
                    $(this).css({'border': '1px solid #ff0000'});
                }
            } else {
                $(this).css({'border': '1px solid #ff0000'});
            }
        });
    });

</script>


<div class="container content">
    <form id="new-product" method="post"
          action="${pageContext.request.contextPath}/new-product/add?${_csrf.parameterName}=${_csrf.token}"
          acceptCharset="utf-8" enctype="multipart/form-data">
        <div class="row wrapper-for-product" style="margin-bottom: 40px">
            <div class="col-lg-4 product-img-1">
                <h2>Nazvanie</h2>
                <div class="wrapper-for-img">
                    <img src="${contextPath}/resources/img/placeholder-image.png">
                </div>
                File to upload: <input type="file" name="file"><br/>
            </div>
            <div class="col-lg-6 description-of-the-product">
                <p class="name-of-product"><spring:message code="product.characteristics"/></p>
                <div class="row" style="margin-bottom: 3%">
                    <div class="col-sm-6">
                        <select style="margin-right: 40px" class="form-control" autofocus name="superCategory" id="select_top_category"
                                onclick="showSubCategories()"
                                onfocus="showSubCategories()">
                            <option disabled>Category</option>
                            <c:forEach items="${topCategories}" var="topCategory">
                                <option value="${topCategory.title}"><spring:message
                                        code="${topCategory.title}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-6">
                        <select class="form-control" name="category" id="select_sub_category"
                                onclick="showAttributes()">
                            <option disabled>Type</option>
                        </select>
                    </div>
                </div>


                <div class="col-md-6">
                    <div class="form-group row has-feedback">
                        <label class="label-attribute"><spring:message code="TITLE"/></label>
                        <input class="form-control" id="title" name="title" pattern="^[0-9а-яА-ЯёЁa-zA-Z\s-]{1,70}$"
                               placeholder="<spring:message code="TITLE"/>"/>
                    </div>
                </div>

                <div id="wrapper-for-attributes" class="col-md-6"></div>


                <div class="row">
                    <div class="col-md-7" style="margin-right: -30px">
                        <label class="label-attribute"><spring:message code="COST"/> </label>
                        <input id="cost" min="1" class="form-control" type="number" name="cost"
                               placeholder="<spring:message code="COST"/>"/>
                    </div>
                    <div class="col-md-4" style="margin-top: 19px; margin-bottom: 15px">
                        <select name="COST_TYPE" class="form-control">
                            <option disabled><spring:message code="CURRENCY"/></option>
                            <option value="BYN">BYN</option>
                            <option value="$">$</option>
                            <option value="€">€</option>
                        </select>
                    </div>
                </div>


                <div class="col-md-7">
                    <div class="form-group row has-feedback">
                        <label class="label-attribute"><spring:message code="DESCRIPTION"/></label>
                        <textarea class="form-control" name="description"
                                  placeholder="<spring:message code="DESCRIPTION"/>"></textarea>
                    </div>
                </div>


                <input class="btn btn-success"  type="submit" style="margin-left: 300px; margin-bottom: 10px"/>


            </div>
        </div>
    </form>


</div>


</body>