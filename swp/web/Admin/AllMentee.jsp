<%-- 
    Document   : AllMentee
    Created on : Feb 1, 2024, 9:19:44 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            .header{
                text-align: center;
                margin: 40px;
            }
            table {
                border-collapse: collapse;
                width: 100%;
            }
            td, th {
                border: 1px solid black;
                padding: 8px;
            }
            .h5, h5 {
                font-size: 1.25rem;
                margin: 40px;
            }
            body{
                background: bisque;
            }
        </style>
    </head>
    <body>

        <div class = "container">
            <h1 class="header">Statistic of all Mentee </h1>
            <div class="header">             
                <h5>Total of Mentee: ${result}</h5>            
            </div>
        </div>
        <div class = "container">
            <table border="1" class="container">
                <tr >
                    <td >Full Name</td>
                    <td >Username</td>
                    <td >NumRequests</td>
                    <td >TotalHours</td>
                    <td >TotalSkills</td>
                </tr>
                <c:forEach items="${list}"  var="e">
                    <tr>
                        <td>${e.getFullName()}</td>
                        <td>${e.getUserName()}</td>
                        <td>${e.getNumRequests()}</td>
                        <td>${e.getTotalHours()}</td>
                        <td>${e.getTotalSkills()}</td>               
                    </tr>
                </c:forEach>

            </table>
        </div>

    </body>
</html>
