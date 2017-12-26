<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title><spring:message code="PAGE_TITLE"/> <spring:message code="edit_product"/></title>

</head>
<body>


<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>

<script type="text/javascript">

    $(document).ready(function () {
        //    скопка сабмит
        $('#edit_product').click(function () {
            if ($('#title').val() != '' &&
                $('#cost').val() != '') {
                var patternTitle = /^[0-9а-яА-ЯёЁa-zA-Z\s-]{1,70}$/i;
                var patternCost = /^([1-9]+([0-9]+)?){0,40}$/i;
                if (patternTitle.test($('#title').val()) &&
                    patternCost.test($('#cost').val())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        });

        //Поля красный/зеленый
        $('#title').on("input", function () {
            if ($(this).val() != '') {
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
    <f:form method="post" action="/product/edit/${ID}?${_csrf.parameterName}=${_csrf.token}" acceptCharset="utf-8" enctype="multipart/form-data">

        <div class="row wrapper-for-product" style="margin-bottom: 40px">
            <div class="col-lg-4">
                <label class="btn btn-default col-md-10 col-md-offset-1">
                    <div class="wrapper-for-img">
                        <div id="fld">
                            <img src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=${IDProduct.photo}"
                                 onerror="this.src='${contextPath}/resources/img/placeholder-image.png'"/>
                        </div>
                        <output id="list"></output>
                    </div>
                    <spring:message code="profile.addPhoto"/>
                    <input type="file" id="file" name="file" />


                </label>
                <span id="errorPhoto"></span>
            </div>
            <div class="col-lg-6 description-of-the-product">
                <p class="name-of-product"><spring:message code="product.characteristics"/></p>

                <div class="row" style="margin-bottom: 3%">
                    <div class="col-sm-6">
                        <h3><label class="label-attribute-2">
                            <spring:message code="${IDProduct.superCategory}"/></label></h3>
                    </div>
                    <div class="col-sm-6">
                        <h3><label class="label-attribute-2">
                            <spring:message code="${IDProduct.category}"/></label></h3>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group row has-feedback">
                        <label class="label-attribute"><spring:message code="PRODUCT_CREATE_DATE_TIME"/></label>
                        <h4><label class="label-attribute-2">${IDProduct.publicationDate}</label></h4>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group row has-feedback">
                        <label class="label-attribute"><spring:message code="PRODUCT_LAST_EDIT_DATE_TIME"/></label>
                        <h4><label class="label-attribute-2">${IDProduct.dateOfLastEdit}</label></h4>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group row has-feedback">
                        <label class="label-attribute"><spring:message code="TITLE"/></label>
                        <input class="form-control" id="title" name="title" value="${IDProduct.title}"
                               placeholder="<spring:message code="TITLE"/>"/>
                    </div>
                </div>


                <c:forEach  items="${IDProduct.attributesAndValues}" var="Values" varStatus="status">
                    <div class="col-md-6">
                        <div class="form-group row has-feedback">
                            <label class="label-attribute"><spring:message code="${Values.key}"/></label>
                            <input class="form-control" name="attributesAndValues['${Values.key}']" value="${Values.value}"
                                   placeholder="<spring:message code="TITLE"/>"/>
                        </div>
                    </div>
                </c:forEach>


                <div class="row">
                    <div class="col-md-7" style="margin-right: -30px">
                        <label class="label-attribute"><spring:message code="COST"/> </label>
                        <input id="cost" min="1" class="form-control" type="number"
                               name="cost" value="${IDProduct.cost}"
                               placeholder="<spring:message code="COST"/>"/>
                    </div>
                    <div class="col-md-4" style="margin-top: 19px; margin-bottom: 15px">
                        <select name="COST_TYPE" class="form-control">
                            <option disabled><spring:message code="CURRENCY"/></option>
                            <option <c:if test="${CURRENCY == 'BYN'}">selected </c:if> value="BYN">BYN</option>
                            <option <c:if test="${CURRENCY == '$'}"  >selected </c:if> value="$">$</option>
                            <option <c:if test="${CURRENCY == '€'}"  >selected </c:if> value="€">€</option>
                        </select>
                    </div>
                </div>


                <div class="col-md-7">
                    <div class="form-group row has-feedback">
                        <label class="label-attribute"><spring:message code="DESCRIPTION"/></label>
                        <textarea class="form-control"  name="attributesAndValues['DESCRIPTION']"
                                  placeholder="<spring:message code="DESCRIPTION"/>">${IDProduct.description}</textarea>
                    </div>
                </div>

                <input class="btn btn-success" id="edit_product" type="submit" value="<spring:message code="button.send"/>" style="margin-left: 300px; margin-bottom: 10px"/>


            </div>
        </div>
    </f:form>
</div>
<%--<div class="container content">--%>
    <%--<div class="row wrapper-for-product">--%>
        <%--<div class="col-lg-4 product-img-1">--%>
            <%--<h2>${IDProduct.title}</h2>--%>
            <%--<div class="wrapper-for-img">--%>
                <%--<img src="${contextPath}/resources/img/placeholder-image.png">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="col-lg-6 description-of-the-product">--%>
            <%--<p class="name-of-product"><spring:message code="product.characteristics"/></p>--%>
            <%--<f:form method="post" action="/product/edit/${ID}" acceptCharset="utf-8">--%>

                <%--<table class="row-distance">--%>
                    <%--<tr>--%>
                        <%--<td><spring:message code="PRODUCT_CREATE_DATE_TIME"/></td>--%>
                        <%--<td>${IDProduct.publicationDate}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><spring:message code="PRODUCT_LAST_EDIT_DATE_TIME"/></td>--%>
                        <%--<td>${IDProduct.dateOfLastEdit}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><spring:message code="STATUS"/></td>--%>
                        <%--<td>${IDProduct.productStatus}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><spring:message code="TELEPHONE"/></td>--%>
                        <%--<td>${IDProduct.phone}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><spring:message code="COST"/></td>--%>
                        <%--<td><input class="fill-whole-cell" name="attributesAndValues['COST']" value="${IDProduct.cost}"></td>--%>
                    <%--</tr>--%>
                    <%--<c:forEach  items="${IDProduct.attributesAndValues}" var="Values" varStatus="status">--%>
                        <%--<tr>--%>
                            <%--<td><spring:message code="${Values.key}"/></td>--%>
                            <%--<td><input class="fill-whole-cell" name="attributesAndValues['${Values.key}']" value="${Values.value}"></td>--%>
                        <%--</tr>--%>

                    <%--</c:forEach>--%>

                    <%--<tr>--%>
                        <%--<td colspan="2"><spring:message code="DESCRIPTION"/></td>--%>
                    <%--</tr>--%>

                    <%--<tr>--%>
                        <%--<td colspan="2" class="comment_edit_product">--%>
                            <%--&lt;%&ndash;<input class="fill-whole-cell text-in-user-comment" name="attributesAndValues['DESCRIPTION']" value="${IDProduct.description}">&ndash;%&gt;--%>
                            <%--<textarea class="fill-whole-cell" name="attributesAndValues['DESCRIPTION']">${IDProduct.description}</textarea>--%>
                        <%--</td>--%>
                    <%--</tr>--%>

                    <%--<tr>--%>
                        <%--<td colspan="2"><input type="submit" value="Изменить" class="fill-whole-cell"/></td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</f:form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%@include file="../layouts/footer_layout.jsp"%>
<script>
    function handleFileSelect(evt) {
        var f = evt.target.files;
        if(f[0].size > 1000000){
            $('#errorPhoto').empty();
            $('#errorPhoto').append("Ошибка!!! Размер файла превышает допустимый.");
            $('#list').empty();
            $('#list').append("");
            var reader = new FileReader();
            reader.onload = (function() {
                return function() {
                    var span = document.createElement('span');
                    document.getElementById('list').insertBefore(span,null);
                };
            })(f[0]);
            reader.readAsDataURL(f[0]);
        }
        else{
            if (f[0].type.match('image.*')) {
                $('#errorPhoto').empty();
                $('#errorPhoto').append(" ");
                $('#list').empty();
                $('#list').append("");
                var reader = new FileReader();
                reader.onload = (function(theFile) {
                    return function(e) {

                        if (document.getElementById('fld') != null) {
                            var el = document.getElementById('fld');
                            el.parentNode.removeChild(el);
                        }

                        var span = document.createElement('span');
                        document.getElementById('list').insertBefore(span,null);
                        span.innerHTML = ['<img class="thumb" src="', e.target.result,
                            '" title="', escape(theFile.name), '"/>'].join('');
                        document.getElementById('list').insertBefore(span, null);
                    };
                })(f[0]);
                reader.readAsDataURL(f[0]);
            }
        }
    }
    document.getElementById('file').addEventListener('change', handleFileSelect, false);
</script>
</body>
</html>