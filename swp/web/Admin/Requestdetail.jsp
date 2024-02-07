<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/pro.css"/>
    </head>
    <body>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row mx-2 my-2">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5 mb-5" width="150px" src="${requestList[0].avatar}">
                        <span class="font-weight-bold">Fullname: ${requestList[0].fullname}</span>
                        <span class="font-weight-bold">Dob: ${requestList[0].dob}</span>
                        <span class="font-weight-bold">Sex: ${requestList[0].sex}</span>
                        <span class="font-weight-bold">Phone: ${requestList[0].phone}</span>
                        <span class="font-weight-bold">Address: ${requestList[0].address}</span>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Detail Request</h4>
                        </div>

                        <!-- Table inside the form with adjusted column widths -->
                        <table class="table" style="border: 1px solid black; table-layout: fixed; width: 200%;">
                            <thead style="border: 1px solid black;">
                                <tr>
                                    <th style="width: 13%;">IdMentee</th>
                                    <th style="width: 13%;">IdRequest</th>
                                    <th>Title</th>
                                    <th>Content</th>
                                    <th>Status</th>
                                    <th>Skill</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="requestDetail" items="${requestList}">
                                    <tr>
                                        <td>${requestDetail.idMentee}</td>
                                        <td>${requestDetail.idRequest}</td>
                                        <td>${requestDetail.title}</td>
                                        <td>${requestDetail.content}</td>
                                        <td>${requestDetail.status}</td>
                                        <td>${requestDetail.skill}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <!-- Back button -->
                        <div class="mt-3">
                            <a href="viewall" class="btn btn-secondary">Back</a>
                        </div>

                        <!-- Link Bootstrap and jQuery JavaScript -->
                        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
