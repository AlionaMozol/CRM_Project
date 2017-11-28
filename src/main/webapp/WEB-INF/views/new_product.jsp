<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content=" width=device-width, initial-scale=1.0">

    <title>Netcufar | New Product</title>

    <script src="../../resources/js/new_product.js"></script>

</head>

<body>

<%@include file="../layouts/preloader.jsp"%>
<%@include file="../layouts/high_menu_bar.jsp"%>

<script type="text/JavaScript"
        src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js">
</script>

<script type="text/javascript">
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
                        "<tr>" +
                        "   <td>" + value + "</td>" +
                        "   <td><label>" +
                        "       <input name=" + value+ "value=" + "${product.attributesAndValues}"+" >" +
                        "   </label></td>" +
                        "</tr>");
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
                    var newOption = ("<option value=" + value.title + ">" + value.title + "</option>");
                    $('#select_sub_category').append(newOption);
                })
            },
            error: function () {
                alert('Error');
            }
        });

    }
</script>

<div style="padding: 100px">
    <f:form method="post" commandName="product" action="/new-product/add/" acceptCharset="utf-8">
        <table>
            <tr>
                <td>
                    <p><f:select path="superCategory" id="select_top_category" onchange="showSubCategories()">
                        <option disabled>Category</option>
                        <c:forEach items="${topCategories}" var="topCategory">
                        <option value="${topCategory.title}">${topCategory.title}</option>
                        </c:forEach>
                        </f:select>
                </td>
            </tr>
            <tr>
                <td>
                    <p>
                        <f:select path="category" id="select_sub_category" onchange="showAttributes()">
                            <option disabled>Type</option></f:select>
                    </p>
                </td>
            </tr>

            <tr>
                <input name="${product.owner}" hidden="hidden" value="${pageContext.request.userPrincipal.name}"/>
            </tr>


            <c:forEach  items="${product.attributesAndValues}" var="attributesAndValues">
                <tr>
                    <td>${attributesAndValues.key}</td>
                    <td>
                        <label>
                                <input name="attributesAndValues['${attributesAndValues.key}']"
                                       value="${attributesAndValues.key}">
                        </label>
                    </td>
                </tr>
            </c:forEach>

            <tr id="wrapper-for-attributes">

            </tr>
            <tr>
                <td><input id="submit-button" hidden="hidden" type="submit"/></td>
            </tr>
        </table>
    </f:form>

</div>

</body>