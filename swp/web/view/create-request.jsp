<%@ page import="java.util.List" %>
<%@ page import="dal.ViewStatisticRequestDAO" %>
<%@ page import="model.Mentor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Request</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
            }

            .container {
                max-width: 600px;
                margin: 50px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                margin-bottom: 30px;
            }

            label {
                font-weight: bold;
            }

            select,
            input[type="text"],
            input[type="date"],
            textarea {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }

            textarea {
                height: 100px;
                resize: none;
            }

            button[type="submit"] {
                display: block;
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }

            button[type="submit"]:hover {
                background-color: #0056b3;
            }

            .alert {
                margin-top: 20px;
                padding: 10px 15px;
                border-radius: 5px;
            }

            .alert-success {
                background-color: #d4edda;
                border-color: #c3e6cb;
                color: #155724;
            }

            .alert-danger {
                background-color: #f8d7da;
                border-color: #f5c6cb;
                color: #721c24;
            }
            .btn {
                display: inline-block;
                padding: 0.5em 1em;
                text-decoration: none;
                background-color: #007bff; /* Button background color */
                color: #fff; /* Button text color */
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s ease;
                line-height: 1.5em;
            }

            /* Hover effect */
            .btn:hover {
                background-color: #0056b3; /* Darker background color on hover */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Create Request</h2>
            <form action="Request?action=create" method="post">
                <label for="mentor">Select Mentor:</label>
                <select id="mentor" name="idMentor">
                    <c:forEach var="mentorItem" items="${listMentor}">
                        <option value="${mentorItem.idMentor}">${mentorItem.fullname}</option>
                    </c:forEach>
                </select>

                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>

                <label for="content">Content:</label>
                <textarea id="content" name="content" required></textarea>

                <label for="deadlineDate">Deadline Date:</label>
                <input type="date" id="deadlineDate" name="deadlineDate" required>

                <label for="deadlineHour">Deadline Hour:</label>
                <input type="text" id="deadlineHour" name="deadlineHour" required>

                <div class="form-group">
                    <label for="skills">Select Skills:</label><br>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="skills" value="Java">
                        <label class="form-check-label">Java</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="skills" value="Python">
                        <label class="form-check-label">Python</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="skills" value="NodeJS">
                        <label class="form-check-label">NodeJS</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="skills" value="C++">
                        <label class="form-check-label">C++</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="skills" value="C#">
                        <label class="form-check-label">C#</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="skills" value="React">
                        <label class="form-check-label">React</label>
                    </div>
                </div>


                <div style="display: flex; justify-content: center;">
                    <button type="submit" style="width: 48%; margin-right: 4%;">Create Request</button>
                    <a href="home.jsp" class="btn" style="text-align: center;">Back to Homepage</a>
                </div>


            </form>
            <c:if test="${param.msg != null}">
                <div class="alert alert-success" role="alert">
                    Create successful!
                </div>
            </c:if>
            <c:if test="${param.fail != null}">
                <div class="alert alert-danger" role="alert">
                    Create failed. Please try again.
                </div>
            </c:if>
        </div>
    </body>
</html>
</html>
