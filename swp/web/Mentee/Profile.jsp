<%-- 
    Document   : Profile
    Created on : Jan 30, 2024, 11:01:36 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_profile.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
      
          <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
              crossorigin="anonymous" />
        <style>
            .image-container {
                position: relative;
                display: inline-block;
            }

            .image-container img {
                display: block;
            }

            .image-container label {
                position: absolute;
                bottom: 5px;
                left: 5px; 
                background: rgba(255, 255, 255, 0.7); 
                padding: 5px; 
                margin-left: 100px;
            }
            .check a{
               text-decoration: none;
               
            }
            
        </style>
    </head>
    <body>
        <div class="container">
            <div class="main-body">

                <!-- Breadcrumb -->

                <!-- /Breadcrumb -->

                <div class="row gutters-sm">
                    <div class="col-md-4 mb-3">
                        <div class="card">
                            <div class="card-body">
                                <form action ="profileMentee" enctype="multipart/form-data" method ="post" >
                                    <div class="d-flex flex-column align-items-center text-center">
                                        <div class="display">
                                            <div class="image-container">
                                                <img src="${mentee.avatar}" class="rounded-circle" width="150">
                                                <label for="input-file" class="fas fa-file" ></label>
                                                
                                               
                                            </div>
                                        </div>


                                        <div class="image">                                         
                                            <input type="file" name = "imageprofile" value="${mentee.avatar}" id="input-file">                                        
                                            <button for ="input-file"type="submit">Update image</button>
                                        </div>

                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="card mt-3">

                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="card mb-3">

                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Account name: </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${account.user}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Full Name: </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${mentee.fullname}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email: </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${account.email}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Date of birth: </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${mentee.dob}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Sex: </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${mentee.sex}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Address</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${mentee.address}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-12">
                                         <div class="check"> <a href="home.jsp" style=" color: white; background: red">Back</a></div>
                                        <div class="check"> <a href="update" style=" color: white; background: green">Edit</a></div>
                                       
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="row gutters-sm">
                            <div class="col-sm-6 mb-3">
                                <div class="card h-100">


                                </div>



                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
