<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Requests</title>
    <link rel="stylesheet" href="css/viewrequestmentor.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
</head>
<body>
    <div style="background-color: #3BB3F6; text-align: left; padding: 10px; margin-bottom: 20px;">
        <a href="home" style="text-decoration: none; color: white; display: flex; align-items: center;">
            <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
        </a>
        <h1 style="text-align: center;">View List Requests</h1>
    </div>
    <h1 style="color: Red; text-align: center;">${errorMessage}</h1>

    <c:if test="${isMentor}">
        <table border="1">
            <thead>
                <tr>
                    <th style="width: 15%;">Title</th>
                    <th>Content of request</th>
                    <th>Start Date</th>
                    <th>Deadline Date</th>
                    <th style="width: 10%;">Deadline Hour (h)</th>
                    <th>Skills</th>
                    <th>Status</th>
                    <th style="width: 8%;">Actions</th>
                </tr>
            </thead>
            <tbody style="text-align: center;">
                <c:forEach var="a" items="${listR}">
                    <tr style="height: 10%;">
                        <td>${a.title}</td>
                        <td>${a.content}</td>
                        <td>${a.startDate}</td>
                        <td>${a.deadline}</td>
                        <td>${a.hour}</td>
                        <td>${a.skill}</td>
                        <td>${a.status}</td>
                        <td class="btn-container">
                            <button onclick="confirmReject(${a.idRequest});" style="background-color: red; border-radius: 5px; border: none; height: 30px; width: 60px; margin-left: 5px;">
                                <a style="text-decoration: none; color: white;" href="#">Reject</a>
                            </button>
                            <button onclick="confirmAccept(${a.idRequest});" style="background-color: green; border-radius: 5px; border: none; height: 30px; width: 60px">
                                <a style="text-decoration: none; color: white;" href="#">Accept</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <script src="https://kit.fontawesome.com/your-font-awesome-kit-code.js" crossorigin="anonymous"></script>
    <script>
        function confirmReject(idRequest) {
            if (confirm('Are you sure you want to reject this request?')) {
                // If user clicks OK, redirect to the reject servlet
                window.location.href = 'reject?idRequest=' + idRequest + '&action=reject';
            }
        }

        function confirmAccept(idRequest) {
            if (confirm('Are you sure you want to accept this request?')) {
                // If user clicks OK, redirect to the accept servlet
                window.location.href = 'accept?idRequest=' + idRequest + '&action=accept';
            }
        }
    </script>
</body>
</html>
