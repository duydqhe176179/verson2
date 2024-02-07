<%-- 
    Document   : login
    Created on : Jan 8, 2024, 9:26:26 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
        <div class="wapper">
            <div class="back"><a href="home.jsp"><i class="fa fa-home" style="font-size: 24px;color: black;"></i></a></div>
            <form action="signin" method="post">
                <p style="text-align: center; color: green;"> ${messsucces}</p>
                <h1>Sign in</h1>
                <div class="input-box">
                    <input type="text" id="uname" name="username" placeholder="Username" required>   
                </div>    
                <div class="input-box">
                    <input type="password" id="pass" name="password" placeholder="Password" required>   
                </div> 
                <p style="margin-bottom: 10px;color: red;font-size: large">${mess}</p>
                <div class="remember">
                    <label style="text-align: left"><input type="checkbox"  name="remember pass" >Remember password</label> 
                    <a href="reset-password">Reset password</a> 
                </div>

                <button class="button" type="submit" name="signup">
                    LOGIN
                </button>
                <div class="resiter-link">
                    <p>Don't have an account? </p>
                    <a ><a href="signup" >Register</a>
                </div>

            </form>

        </div>
    </body>
</html>
