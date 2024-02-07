<%-- 
    Document   : changepass
    Created on : Jan 9, 2024, 4:18:02 PM
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
            <form action="changePass" method="post">
                <div class="back"><a href="home.jsp"><i class="fa fa-home" style="font-size: 24px;color: black;"></i></a></div>
                
                <h1>Change Password</h1>
                <p style="text-align: center;">Please enter your user name and password</p>
                <p style="text-align: center; color: green;"> ${messsucces}</p>
                <p style="text-align: center; color: red;"> ${error}</p>
                <p style="text-align: center; color: red;"> ${err}</p>
                <p style="text-align: center; color: red;"> ${erro}</p>
                 <div class="input-box">
                     <input type="text"  name="username" placeholder="Username" required>   
                </div>
                <div class="input-box">
                    <input type="password"  name="oldpassword" placeholder="Old Password" required>   
                </div>
                <div class="input-box">
                    <input type="password"  name="newpassword" placeholder="New Password" required>   
                </div>
                <div class="input-box">
                    <input type="password"  name="confirm" placeholder="Confirm new password" required>   
                </div>
                <button class="button" type="submit" name="signup">
                    Change Password
                </button>
                
            </form>

        </div>




    </body>
</html>
