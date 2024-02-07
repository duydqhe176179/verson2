<%-- 
    Document   : CreateCV
    Created on : Jan 18, 2024, 10:09:37 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_4.css"/>
<!--        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style4.css"/>-->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/js1.js"></script>

        <style>
            #msform input, #msform textarea {

                border-radius: 0px;
                margin-bottom: 0px;
                margin-top: 2px;

            }
            body{
                display: flex;
                align-items: center;
                justify-content: center;
                min-height: 100vh;
                padding: 10px;
                font-family: 'Poppins', sans-serif;
                background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
            }
            #heading {

                text-align: center;
                font-size: 35px;
            }
            p {
                color: grey;
                text-align: center;

                font-size: 18px;
            }

            .fs-title {

                margin-left: 20px;
                margin-top: 20px;
                margin-bottom: 0px;
            }
            .bb{
                margin:30px;
            }
            .fieldlabels {
                color: gray;
                text-align: left;
                margin-top: 10px;
            }
        </style>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const allStar = document.querySelectorAll('.rating .star');
                const ratingValue = document.querySelector('.rating input');

                allStar.forEach((item, idx) => {
                    item.addEventListener('click', function () {
                        let click = 0;
                        ratingValue.value = idx + 1;

                        allStar.forEach(i => {
                            i.classList.replace('bxs-star', 'bx-star');
                            i.classList.remove('active');
                        });

                        for (let i = 0; i < allStar.length; i++) {
                            if (i <= idx) {
                                allStar[i].classList.replace('bx-star', 'bxs-star');
                                allStar[i].classList.add('active');
                            } else {
                                allStar[i].style.setProperty('--i', click);
                                click++;
                            }
                        }
                    });
                });
            });


        </script>

    </head>
    <body>

        <div class="container-fluid">

            <div class="row justify-content-center">
                <div class="col-11 col-sm-10 col-md-10 col-lg-6 col-xl-5 text-center p-0 mt-3 mb-2">
                    <div class="card px-0 pt-4 pb-0 mt-3 mb-3">
                        <h2 id="heading">Update cv of Mentor</h2>
                        <p>Fill all form field to go to next step</p>
                        <form id="msform" method="POST" action="createcv" enctype="multipart/form-data" style="margin-top: 30px" onsubmit="return submitForm();">
                            <!-- progressbar -->
                            <ul id="progressbar">
                                <li class="active" id="account"><strong>Users Info</strong></li>
                                <li id="personal"><strong>Profession</strong></li>
                                <li id="payment"><strong>Skills</strong></li>
                                <li id="confirm"><strong>Finish</strong></li>
                            </ul>
                            <div class="progress">
                                <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>
                            </div> <br> <!-- fieldsets -->

                            <fieldset>
                                <div class="form-card">
                                    <div class="row">
                                        <div class="col-7">
                                            <h2 class="fs-title">Account User: ${cx.user}</h2>
                                        </div>
                                    </div> 
                                    <div class="container bb">
                                        <label class="fieldlabels">Upload Your Photo:</label>
                                        <input type="file" name="image" value="${mentor.avatar}">                                                                           
                                        <label class="fieldlabels">Email: *</label> 
                                        <input  type="email" name="email" id="emailInput" placeholder="Email" value="${cx.email}" readonly/> 

                                        <label class="fieldlabels">Fullname: *</label> 
                                        <input  type="text" name="uname" placeholder="FullName" value="${mentor.fullname}" />                                      
                                        <label class="fieldlabels">Sex: *</label> 
                                          <!--  <input  type="text" name="gender" placeholder="Sex" value="${mentor.sex}" readonly/> -->
                                        <select class="fieldlabels" name="gender" value="${mentor.sex}">
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                            <option value="Others">Others</option>

                                        </select>
                                            <br/>
                                        <label   class="fieldlabels">Date: *</label> 
                                        <input  type="date" name="date" placeholder="Date" value="${mentor.dob}"/>
                                        <label class="fieldlabels">Address: *</label> 
                                        <input type="text" name="address" placeholder="Address" value="${mentor.address}"/>
                                        <label class="fieldlabels">Phone: *</label> 
                                        <input type="text" name="phone" placeholder="Phone" value="${mentor.phone}" required pattern="[0-9]{10}" title="Please enter a 10-digit phone number" />
                                    </div>
                                </div> <input type="button" name="next" class="next action-button" value="Next" />
                            </fieldset>
                            <fieldset>
                                <div class="form-card">
                                    <div class="row">
                                        <div class="col-7">
                                            <h2 class="fs-title">Profession:</h2>
                                        </div>

                                    </div>
                                    <div class="container bb">
                                        <label class="fieldlabels">profession: *</label> 
                                        <input  type="text" name="pwd" placeholder="Profession" value = "${mentor.profession}"/> 
                                        <label class="fieldlabels">Introduction: *</label> 
                                        <input type="text" name="intro" placeholder="Introduction" value="${mentor.pro_introduc}"/> 
                                        <label class="fieldlabels">Experience: *</label> 
                                        <input type="text" name="experience" placeholder="Experience" value="${mentor.experience}" /> 
                                        <label class="fieldlabels">My Services: *</label> 
                                        <input type="text" name="service" placeholder="My Services" value="${mentor.myservice}"/>
                                        <label class="fieldlabels">Education: *</label> 
                                        <input type="text" name="education" placeholder="Education" value="${mentor.education}"/>
                                        <label class="fieldlabels">Achivement: *</label> 
                                        <input type="text" name="achivement" placeholder="Achivement" value="${mentor.archivement_sescition}"/>

                                    </div> 
                                </div>
                                <input type="button" name="next" class="next action-button" value="Next" /> 
                                <input type="button" name="previous" class="previous action-button-previous" value="Previous" />
                            </fieldset>
                            <fieldset>
                                <div class="form-card">

                                    <div class="container bb">

                                        <!--                                        <label class="fieldlabels">Skills: *</label> -->

                                        <c:forEach var="e" items="${skill}">
                                            <div class="form-check form-switch">
                                                <input class="form-check-input skillCheckbox"  type="checkbox" name="skills" value="${e.id}">
                                                <label class="form-check-label"  for="skills" >${e.skillName}</label><br>
                                            </div> 
                                        </c:forEach>
                                        <br>


                                        <label class="fieldlabels">Programing framework: *</label> 
                                        <input type="text" name="framework" placeholder="Framework" value="${mentor.framework}"/>




                                    </div>
                                </div> 
                                <div class="form-card">
                                    <button type="submit" class="next action-button" onclick="confirm('Are you sure to update ')"style=" color: white; background: green">Update</button>

                                </div>
                                <!--                                <input type="button" id="nextButton" name="next" class="next action-button" value="Next" /> -->
                                <input type="button" name="previous" class="previous action-button-previous" value="Previous" />
                            </fieldset>
                            <fieldset>

                            </fieldset>
                            ${mess}
                        </form>



                    </div>
                </div>
            </div>

        </div>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>


    </body>
</html>
