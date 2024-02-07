<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <script src="https://cdn.tiny.cloud/1/v2saiqx68nn924zq9xagmn8galaqifhtnlhjbr6jeofrd8n1/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <style>
            td{
                text-align: center;
            }
            th{
                padding: 10px;
            }
            .refresh{
                padding-left: 20px;
                padding-bottom: 10px;
            }
            .refresh input{
                background: #0354D5;
                color: white;
                border: none;
                padding: 5px 10px;
            }
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #F37125;
                color: white;
                padding: 10px;
                text-align: center;
            }
            th{
                text-align: center
            }



            section {
                padding: 20px;
            }
            .logout-container {
                text-align: center;
                margin-top: 100px;
            }

        </style>
    </head>
    <body >
        <header>
            <div class="row">
                <div class="col-sm-2">
<!--                    <img src="img/logo.png" width="100%" " alt="alt"/> -->
                </div>
                <div class="col-sm-10">
                    <h1>Admin Page</h1>
                </div>
            </div>
        </header>

        <div class="container">
            <section class=" row">
                <!-- Admin content goes here -->
                <h2 class="col-sm-11">Welcome, ${account.user}!</h2>
                <div class="col-sm-1">
                    <a class="btn btn-danger" href="logoutAdmin" style="width: 100%">Log out</a>
                </div>
            </section>



            <br><br>
            <form  class="refresh" action="displayRegister" method="post">
                <button type="submit" value="Refresh" class="btn btn-primary">
                    <i class="fa-solid fa-rotate-right"></i> Refresh
                </button>
            </form>
            <h3>Mentor<a href="addInfo"><i class="fa-solid fa-plus"></i></a></h3><br>


            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <br><br><br>
            <h3>Statistic of Mentee<a href="statistic"><i class="fa-solid fa-plus"></i></a></h3><br>


            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <br><br><br>

            <h3>Mentee <a href="addInfo"><i class="fa-solid fa-plus"></i></a></h3><br>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>


                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <br><br><br>

            <h3>Request <a href="addOldStudent"><i class="fa-solid fa-plus"></i></a></h3><br>
            <h3 style="text-decoration: none;"><a href="viewall">ViewRequest</a></h3>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${listO}" >
                            <tr>
                                <td>${o.name}</td>
                                <td><a href="updateOldStudent?id_old=${o.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                                <td><a href="deleteOldStudent?id_old=${o.id}" onclick="return confirmAccess('${link.url}')"><i class="fa-solid fa-trash"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <br><br><br>

            <h3>Skills <a href="addSkill"><i class="fa-solid fa-plus"></i></a></h3><br>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${listSkill}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${s.getId()}</td>
                                <td>${s.getTiltle()}</td>
                                <td><img src="${s.getImage()}" width="100rem"  alt="alt"/></td>
                                <td>${s.getSkillName()}</td>
                                <td>${s.getSkill_description()}</td>
                                <c:if test="${s.getStatus() eq 'enable'}" >
                                    <td style="color: #01df1f">
                                        <p style="font-size: large">${s.getStatus()}</p>
                                        <a class="btn btn-danger" href="activeSkill?idSkill=${s.getId()}" style="width: 70%">Disable</a>
                                    </td>
                                </c:if>
                                <c:if test="${s.getStatus() ne 'enable'}" >
                                    <td style="color: #ff1921">
                                        <p style="font-size: large">${s.getStatus()}</p>
                                        <a class="btn" style="background-color: #4acd3d; color: white;" href="activeSkill?idSkill=${s.getId()}" style="width: 70%">Enable</a>
                                    </td>
                                </c:if>
                                <td><a href="updateSkill?idSkill=${s.getId()}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <br><br>

        <footer >
            @Admin
            <p>&copy; 2023 Your Company. All rights reserved. | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>

        </footer>
        <script>
            function confirmAccess(url) {
                var confirmation = confirm("Do you want to delete ?");
                if (confirmation) {
                    // User confirmed, access the link
                    window.location.href = url;
                } else {
                    // User canceled, do nothing
                    return false;
                }
            }
        </script>

    </body>
</html>
