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

    <title>Log in with your account</title>

    <link rel="stylesheet" media="screen" href="../../resources/css/profile.css">

</head>

<body>

    <form class="contact_form" action="#" method="post" name="contact_form">
        <ul>
            <li>
                <h2>Contact Us</h2>
                <span class="required_notification">* Denotes Required Field</span>
            </li>
            <li>
                <!-- Имя/-->
                <label>Name:</label>
                <input type="text"  placeholder="John Doe" required />
            </li>
            <li>
                <!-- Имя/-->
                <label>Email:</label>
                <input type="email" name="email" placeholder="john_doe@example.com" required />
                <span class="form_hint">Proper format "name@something.com"</span>
            </li>
            <li>
                <!-- Имя/-->
                <label>Website:</label>
                <input type="url" name="website" placeholder="http://johndoe.com" required pattern="(http|https)://.+"/>
                <span class="form_hint">Proper format "http://someaddress.com"</span>
            </li>
            <li>
                <label>Message:</label>
                <textarea name="message" cols="40" rows="6" required ></textarea>
            </li>
            <li>
                <button class="submit" type="submit">Submit Form</button>
            </li>
        </ul>
    </form>

</body>