<%-- 
    Document   : loginAdmin
    Created on : Jan 16, 2024, 5:31:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>CodePen - A Pen by Mohithpoojary</title>
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css'>
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/fontawesome.css'>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_login_admin.css"/>
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="container">
            <div class="screen">
                <div class="screen__content">
                    <h2 style="color: #0c63e4;margin-top: 40px;margin-left: 10px">Only for Admin</h2>
                    <h1 style="color: red">${mess}</h1>
                    <form class="login" action="signinAdmin" method="post">
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>
                            <input type="text" name="user" class="login__input" placeholder="User name">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input type="password" name="pass" class="login__input" placeholder="Password">
                        </div>
                        <button class="button login__submit">
                            <span class="button__text">Log In Now</span>
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>				
                    </form>

                </div>
                <div class="screen__background">
                    <span class="screen__background__shape screen__background__shape4"></span>
                    <span class="screen__background__shape screen__background__shape3"></span>		
                    <span class="screen__background__shape screen__background__shape2"></span>
                    <span class="screen__background__shape screen__background__shape1"></span>
                </div>		
            </div>
        </div>
        <!-- partial -->

    </body>
</html>

