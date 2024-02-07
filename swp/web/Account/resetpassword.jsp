<%-- 
    Document   : login
    Created on : Jan 8, 2024, 9:26:26 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style_1.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
        <div class="wapper">
            <div class="back"><a href="signin"><i class="fa-solid fa-arrow-left"></i></a></div>
            <div class="back"><a href="home"><i class="fa fa-home" style="font-size: 24px;color: black;"></i></a></div>
            <form action="reset-password" method="post">
                <h1>Reset Password</h1>
                <p style="text-align: center;">If you've forgotten your password, enter your account and email</p>
                <div class="input-box">
                    <input type="text" id="aname" name="accountname" placeholder="Account name" required>   
                </div>    
                <div class="input-box">
                    <input type="email" id="email" name="emailaddress" placeholder="Email address" required>   
                </div> 
                ${message}
                <button class="button" type="submit" name="signup">
                    Enter
                </button>

            </form>

        </div>
    </body>
</html>