<%-- 
    Document   : updatereq
    Created on : Feb 6, 2024, 12:10:19 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <!--<title>Registration Form in HTML CSS</title>-->
        <!---Custom CSS File--->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylereq.css" />

    </head>
    <body>
        <section class="container">
            <header>Update Request</header>
            <form action="updatereq" method="post"class="form">
                <input type="hidden" value="${idRequest}" name="idRequest">
                <div class="input-box">
                    <label>Title</label>
                    <input type="text" name="title" placeholder="Enter title" required />
                </div>

                <div class="input-box">
                    <label>Skill Description</label>
                    <input type="text" name="sdep" placeholder="Enter skill description" required />
                </div>

                <div class="column">
                    <div class="input-box">
                        <label>Deadline Hour</label>
                        <input type="text" name="hour"placeholder="Enter deadline hour" required />
                    </div>
                    <div class="input-box">
                        <label>Deadline Date</label>
                        <input type="date" name="date"placeholder="Enter deadline date" required />
                    </div>
                </div>
                <div class="gender-box">
                    <h3>Skill</h3>
                    <div class="gender-option">
                        <c:forEach items="${Skill}" var="s">
                            <div class="gender">
                                <input type="radio"  value="${s.getSkillName()}" name="skills"  />
                                ${s.getSkillName()}
                            </div>
                        </c:forEach>


                    </div>
                </div>
                <div class="input-box address">
                    <label>Mentor Name</label>
                    <select name="mentorname">
                        <option hidden>Name</option>
                        <c:forEach items="${MentorName}" var="mn">
                            <option value="${mn.idMentor}">${mn.fullname}</option>
                        </c:forEach>
                    </select>
                    <div class="column">
                        <div class="select-box">
                            <select name="status">
                                <option hidden>Status</option>
                                <option value="Processing">Processing</option>
                                <option value="Open">Open</option>
                                <option value="Closed">Closed</option>
                                <option value="Finished">Finished</option>
                                <option value="Cancel">Cancel</option>
                            </select>
                        </div>

                    </div>

                </div>
                <button>Submit</button>
            </form>
        </section>
    </body>
</html>
