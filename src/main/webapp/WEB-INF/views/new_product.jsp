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
                        "<p class='add-product-attribute'>" +
                            "<label class='label-attribute'> " +
                        messages[value] +
                        "</label>" +
                        "<input name=" + value + " placeholder=" +  messages[value] +"></p>");
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
                $('#wrapper-for-attributes').empty();
                $('#select_sub_category').empty();
                $.each(data, function (index, value) {
                    var newOption = ("<option value=" + value.title + ">" + messages[value.title] + "</option>");
                    $('#select_sub_category').append(newOption);
                })
            },
            error: function () {
                alert('Error');
            }
        });

    }
</script>

<div class="container content">
    <form method="post" action="${pageContext.request.contextPath}/new-product/add?${_csrf.parameterName}=${_csrf.token}" acceptCharset="utf-8" enctype="multipart/form-data">
    <div class="row wrapper-for-product">
        <div class="col-lg-4 product-img-1">
            <h2>Nazvanie</h2>
            <div class="wrapper-for-img">
                <img src="${contextPath}/resources/img/placeholder-image.png">
            </div>
            File to upload: <input type="file" name="file"><br />
        </div>
        <div class="col-lg-6 description-of-the-product">
            <p class="name-of-product"><spring:message code="product.characteristics"/></p>
            <div class="row add-product-category">
                <select name="superCategory" id="select_top_category" onchange="showSubCategories()">
                    <option disabled>Category</option>
                    <c:forEach items="${topCategories}" var="topCategory">
                        <option value="${topCategory.title}"><spring:message code="${topCategory.title}"/> </option>
                    </c:forEach>
                </select>

                <select name="category" id="select_sub_category" onchange="showAttributes()">
                    <option disabled>Type</option>
                </select>
            </div>

            <div class="col-sm-3">
                <p class="add-product-attribute" >
                    <label class="label-attribute"><spring:message code="TITLE"/></label>
                    <input name="TITLE"  placeholder="<spring:message code="TITLE"/>"/>
                </p>
            </div>

            <div id="wrapper-for-attributes" class="col-sm-3"></div>

            <div class="col-sm-3">
                <p class="add-product-attribute">
                    <label class="label-attribute"><spring:message code="COST"/> </label>
                    <input name="COST"  placeholder="<spring:message code="COST"/>"/>
                </p>
                <p class="add-product-attribute">
                    <label class="label-attribute"><spring:message code="DESCRIPTION"/></label>
                    <textarea class="add-product-description" name="DESCRIPTION"  placeholder="<spring:message code="DESCRIPTION"/>"></textarea>
                </p>
            </div>
            <input class="btn btn-success" hidden="hidden" type="submit"/>
        </div>
    </div>
    </form>


</div>


</body>