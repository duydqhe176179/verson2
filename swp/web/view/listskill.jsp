<%-- 
    Document   : listskill
    Created on : Jan 16, 2024, 10:51:39 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Table Example</title>
    <link rel="stylesheet" href="css/styles.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
<c:if test="${not empty listSkill}">
<div class="container">
    <table class="gradient-table" border="1">
        <thead>
            <tr>
                <th>Column 1</th>
                <th>Column 2</th>
                <th>Column 3</th>
                <th>Column 4</th>
                <th>Column 5</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items = "${listAllSkill}" var = "item">
                <tr>
                    <td>${item.title}</td>
                    <td>${item.image}</td>
                    <td>${item.skillName}</td>
                    <td>${item.skill_description}</td>
                    <td>${item.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</c:if>
<c:if test="${empty listSkill}">
    <p>No data available.</p>
</c:if>

</body>
</html>
