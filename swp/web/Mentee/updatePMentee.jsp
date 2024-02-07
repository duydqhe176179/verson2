<%-- 
    Document   : updatePMentee
    Created on : Jan 31, 2024, 9:21:57 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            /* Style for form container */
            form {
                max-width: 400px;
                margin: 0 auto;
            }

            /* Style for input container */
            .input-pro {
                margin-bottom: 15px;

            }


            /* Style for labels */
            label {
                display: inline-block;
                width: 120px;
                font-size: 16px;
                color: #333;
            }

            /* Style for input fields */
            input[type="text"],
            input[type="email"],
            input[type="date"],
            select {
                width: calc(100% - 130px); /* Adjust width to fit label */
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }

            /* Style for select dropdown */
            select {
                width: calc(100% - 130px);
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
                background-color: #fff;
                color: #333;
                margin-bottom: 15px;
            }

            /* Style for submit button */
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }
            .header{
                text-align: center;
                margin-bottom: 50px;
                margin-top: 50px;
            }
            .form-container {
                background-color: #f9f9f9; /* Màu nền */
                padding: 20px;
                border-radius: 8px; /* Góc bo tròn */
                margin: 50px;
            }
            .gg{
                margin-top: 20px;
            }

        </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>

        <div class="form-container">       
            <a href="profileMentee">
                <span class="fa-thin fa-user"></span>
            </a>
            <h1 class="header">
                Update
            </h1>
            <form action="update" method="post">
                <div class="wapper">
                    <div class="input-pro">
                        <label> Account: </label>

                        <input type="text" name="accountname"  value="${account.user}" readonly>   
                    </div> 
                    <div class="input-pro">
                        <label> Email: </label>
                        <input type="email"  name="emails" placeholder="Email" value=" ${account.email}" readonly>   
                    </div> 
                    <div class="input-pro">
                        <label> Full Name: </label>
                        <input type="text"  name="fullnamem" placeholder="Fullname" value="${mentee.fullname}" required>   
                    </div> 
                    <div class="input-pro">
                        <label> Date of birth: </label>
                        <input type="date"  name="birth" placeholder="Date of birth" value="${mentee.dob}" required>   
                    </div> 

                    <label style="font-size: large">Gender:</label>
                    <select class="genderse" name="gengers" value="${mentee.sex}">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Others">Others</option>

                    </select>


                    <div class="input-pro">
                        <label> Address: </label>
                        <input type="text"  name="addresss" placeholder="Address" value=" ${mentee.address}" required>   
                    </div>
                </div>
                <div class="input-pro">

                    <button type="submit" onclick="confirm('Are you sure to update ')"style=" color: white; background: green;margin: 10px;
                            margin-left: 326px;">Update</button>


                </div>
        </div>

    </form>
</div>

</body>
</html>
