<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
        <div class="wapper">
            <div class="back"><a href="home.jsp"><i class="fa fa-home" style="font-size: 24px;color: black;"></i></a></div>
            <form action="signup" method="post">
                <h1>Sign up</h1>
                You are: 
                <select name="role" value="${signup.getRole()}">
                    <option value="Mentor">Mentor</option>
                    <option value="Mentee">Mentee</option>
                </select>
                <div class="input-box">
                    <input type="text" name="username" placeholder="Username" value="${signup.getUser()}" required>   
                </div>    
                <div class="input-box">
                    <input type="password"name="pass" placeholder="Password" value="${signup.getPass()}" required>   
                </div> 
                <div class="input-box">
                    <input type="password" name="repass" placeholder="Re-enter Password" value="${signup.getRepass()}" required>   
                </div>
                <div class="input-box">
                    <input type="email"  name="email" placeholder="Email" oninput="delayedCheckEmailAvailability()" value="${signup.getEmail()}" required>   
                </div> 
                <div class="input-box">
                    <input type="text"  name="fullname" placeholder="Fullname" value="${signup.getFullname()}" required>   
                </div> 
                <div class="input-box">
                    <input type="tel"  name="phone" id="phoneInput" placeholder="Phone" value="${signup.getPhone()}" required pattern="[0-9]{10}">   
                    <span id="phoneWarning" style="color: red;"></span>
                </div> 
                <div class="input-box">
                    <input type="date"  name="birth" placeholder="Birthday" value="${signup.getBirth()}" required>   
                </div> 
                <div class="input-box">
                    <input type="text"  name="address" placeholder="Address" value="${signup.getAddress()}" required>   
                </div>
                <p style="font-size: large">Gender:</p>
                <div class="row">
                    <div class="col-md-4">
                        <input type="radio" name="gender" value="Male"> Male
                    </div>
                    <div class="col-md-4">
                        <input type="radio" name="gender" value="Female"> Female
                    </div>
                    <div class="col-md-4">
                        <input type="radio" name="gender" value="Other"> Other
                    </div>
                </div>
                <br>
                <p style="color: red;font-size: large">${err}</p>


                <button class="button" type="submit" onclick="validatePhoneNumber()" >
                    SIGN UP
                </button>
                <div class="resiter-link">
                    <p>You had account ? </p>
                    <a ><a href="#" >Sign in</a>
                </div>

            </form>

        </div>
        <script>
            function validatePhoneNumber() {
                const phoneNumberInput = document.getElementById('phoneInput');
                const phoneWarning = document.getElementById('phoneWarning');
                const phoneNumber = phoneNumberInput.value.replace(/\D/g, ''); // Remove non-digit characters

                if (phoneNumber.length === 10) {
                    // Phone number is valid
                    phoneWarning.textContent = ''; // Clear the warning message
                    console.log('Valid phone number:', phoneNumber);
                    // You can perform additional actions here if needed
                } else {
                    // Phone number is invalid
                    phoneWarning.textContent = 'Please enter a valid 10-digit phone number';
                    console.log('Invalid phone number:', phoneNumber);
                    // You can display an error message or perform other actions
                }
            }
        </script>
       
    </body>
</html>
