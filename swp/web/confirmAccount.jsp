<%-- 
    Document   : confirmAccount
    Created on : Jan 14, 2024, 3:23:35 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <style>
            body {
                background-image: url('img/header.jpg')
            }
            .wapper{
                width: 500px;
            }
        </style>
    </head>
    <body>
        <div class="wapper">
            <form action="confirm" method="post">
                <h1>Confirm your account</h1>
                <input type="text" name="verify" value="${verify}" style="display: none">
                <div class="input-box">
                    <input type="text" name="confirm" placeholder="Enter your OTP" required>   
                </div>

                <button class="button" type="submit">
                    OK
                </button>
            </form>
                <c:if test="${mess ne null}">
                    <span style="margin: 7px 0;color: #30d82a">${mess}, return <a href="home">home</a></span>
                </c:if>
            ${err}
            <form action="sendEmailVerify" method="post" style="margin-top: 10px">
                <span style="margin-right: 5px">If you don't have any email, click to send again  </span>
                <button class="btn btn-light" type="submit">
                    Send Email
                </button>
            </form>
        </div>
    </body>
</html>