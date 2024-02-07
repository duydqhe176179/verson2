<%-- 
    Document   : newjsp
    Created on : Jan 14, 2024, 5:50:31 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name ="viewport" content="width = device-width, initial-scale = 1" >
        <title>Happy Programming</title>
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
              rel="stylesheet" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
              crossorigin="anonymous" />
        <!--        <link rel="stylesheet"  type="text/css" href="../css/style_2.css"/>-->
        <link rel="shortcut icon" href="./favicon.ico">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_2.css"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            .page {
                position: absolute;
                top: 0;
                bottom: 0;
                left: 0;
                right: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                background: -webkit-linear-gradient(left, #3931af, #00c6ff);
            }
            .profile-background {
                height: 200px;
            }
            .profile-name {
                margin-top: 20px;
                margin-bottom: 30px;
            }
            .profile-profession {
                margin-top: 30px;
                margin-bottom: 30px;
                font-size: larger;
            }
            .profile-image img {
                width: 40%;
                height: 200%;

            }
        </style>
    </head>
    <body>
        <div class="background gradient">

        </div>
        <div class="page">
            <header>
                <nav>
                    <a href="#about" class="selected" id='getAbout'>
                        <span class="fas fa-user"></span>
                        <span class="link">About</span>
                    </a>
                    <a href="#resume" id='getResume'>
                        <span class="fas fa-file"></span>
                        <span class="link">Resume</span>
                    </a>
                    <a href="#contact" id='getContact'>
                        <span class="fas fa-at"></span>
                        <span class="link">Contact</span>
                    </a>
                    <a href="createcv">
                        <span class="fa-solid fa-pen-nib"></span>
                        <span class="link">Update</span>
                    </a>
                    
                    <a href="home.jsp">
                        <span class="fa-thin fa-house"></span>
                        <span class="link">Home</span>
                    </a>
                </nav>
            </header>
            <main>
                <section id="presentation" class="profile">
                    <div class="profile-background"></div>
                    <div>
                        <div class="profile-image">
                            <img src="${cv.getAvatar()}" alt="">
                        </div>
                        <h1 class="profile-name" id="nombre"> ${cv.fullname}</h1>
                        <h2 class="profile-profession"> ${cv.profession}</h2>
                        <!--                        <div class="profile-social" id="profile-social">
                                                    <a href="${cs.link}"><i class="fa-brands fa-facebook"></i> </a>
                                                    <a href="www.instagram.com" class="fa-brands fa-instagram"></a>
                                                    <a href="www.twitter.com" class="fa-brands fa-twitter"></a>
                        
                                                </div>-->
                    </div>

                </section>
                <section id="about" class="about view">
                    <article class="about-aboutMe">
                        <h3 class="title">About Me</h3>
                        <div class="line-left">
                            <p>${cv.pro_introduc}</p>
                            <div>
                                <div>
                                    <span>Date :  </span>${cv.dob}
                                </div> 
                                <div>
                                    <span>AGE :  </span>${cv.age}
                                </div>     
                                <div>
                                    <span>Sex : </span>${cv.sex}
                                </div>

                                <div>
                                    <span>ADDRESS : </span>${cv.address}
                                </div>
                            </div>
                        </div>
                    </article>
                    <article class="about-services">


                        <div class="line-left">
                            <article class="line-down">
                                <div class="fas fa-code"></div>
                                <h4>My services</h4>
                                <p>${cv.myservice}</p>
                            </article>
                            <article class="line-down">
                                <div class="fas fa-code"></div>
                                <h4>Achivements</h4>
                                <p>${cv.archivement_sescition}</p>
                            </article>
                        </div>   

                    </article>

                </section>
                <section id="resume" class="resume">
                    <h3 class="title">Resume</h3>
                    <article class="resume-lines">
                        <section class="resume-line line-left">
                            <h4 class="line-down"> <i class="fas fa-briefcase"></i> Experience</h4>
                            <article class="line-down">


                                <p>${cv.experience}</p>
                            </article>

                        </section>
                        <section class="resume-line line-left">
                            <h4 class="line-down"> <i class="fas fa-university"></i> Education</h4>
                            <article class="line-down">

                                <p>${cv.education}</p>
                            </article>

                        </section>
                    </article>
                    <article class="resume-skills">
                        <h3 class="title">My Skills</h3>
                        <div>
                            <section class="line-left">
                                <h4 class="line-down"> <i class="fas fa-tv"></i> Skills</h4>
                                <c:forEach var="e" items="${cf}">

                                    <div>${e.getSkillname()}</div>


                                </c:forEach>


                            </section>
                            <section class="line-left">
                                <h4 class="line-down"><i class="fas fa-code"></i> FRAMEWORK</h4>

                                <div>${cv.framework}</div>



                            </section>
                        </div>
                    </article>
                </section>
                <section id="contact" class="contact">
                    <h3 class="title">Get in Touch</h3>
                    <div class="contact-information line-left">
                        <div>
                            <span>ADDRESS : </span> ${cv.address}
                        </div>
                        <div>
                            <span>EMAIL : </span> ${cx.email}
                        </div>
                        <div>
                            <span>PHONE : </span>${cv.phone}
                        </div>

                    </div>
                </section>
            </main>
        </div>
    </body>
    <script>
        // Menu links
        let getAbout = document.getElementById("getAbout");
        let getResume = document.getElementById("getResume");
        let getContact = document.getElementById("getContact");

        // Sections
        let about = document.getElementById("about");
        let resume = document.getElementById("resume");
        let contact = document.getElementById("contact");

        function removeClass() {
            // Links
            getAbout.classList.remove('selected');
            getResume.classList.remove('selected');
            getContact.classList.remove('selected');
            // Sections
            about.classList.remove('view');
            resume.classList.remove('view');
            contact.classList.remove('view');
        }

        getAbout.addEventListener('click', function (e) {
            if (window.innerWidth > 1040) {
                e.preventDefault();
                removeClass();
                about.classList.add('view');
                getAbout.classList.add('selected');
            }

        });
        getResume.addEventListener('click', function (e) {
            if (window.innerWidth > 1040) {
                e.preventDefault();
                removeClass();
                resume.classList.add('view');
                getResume.classList.add('selected');
            }
        })
        getContact.addEventListener('click', function (e) {
            if (window.innerWidth > 1040) {
                e.preventDefault();
                removeClass();
                contact.classList.add('view');
                getContact.classList.add('selected');
            }
        })

    </script>
</html>
