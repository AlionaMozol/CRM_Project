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
                        "       <input name=" + value + ">" +
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
    <form method="post" action="/new-product/add?${_csrf.parameterName}=${_csrf.token}" acceptCharset="utf-8" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    <p> <label>Category:</label>
                        <select name="superCategory" id="select_top_category" onchange="showSubCategories()">
                        <option disabled>Category</option>
                        <c:forEach items="${topCategories}" var="topCategory">
                        <option value="${topCategory.title}">${topCategory.title}</option>
                        </c:forEach>
                        </select>
                </td>
            </tr>
            <tr>
                <td>
                    <p>
                        <label>Type:</label>
                        <select name="category" id="select_sub_category" onchange="showAttributes()">
                            <option disabled>Type</option></select>
                    </p>
                </td>
            </tr>

            <tr>
                <td>
                    File to upload: <input type="file" name="file"><br />
                </td>
            </tr>

            <tr>
                <td><label>Title:</label>
                    <input name="TITLE"  value="title"/>
                </td>
            </tr>
            <tr>
                <td><label>COST:</label>
                    <input name="COST"  value="0"/>
                </td>
            </tr>
            <tr id="wrapper-for-attributes">

            </tr>

            <tr>
                <td><label>Description:</label>
                    <input name="DESCRIPTION"  value="DESCRIPTION"/>
                </td>
            </tr>

            <tr>
                <td><input id="submit-button" hidden="hidden" type="submit"/></td>
            </tr>
        </table>
    </form>

</div>

</body>