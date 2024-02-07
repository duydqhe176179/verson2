<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="css/style_rate.css"/>
        <title>Rate&Comment</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="back"><a href="home"><i class="fa fa-home" style="font-size: 24px;color: black; margin-left: -95%;"></i></a></div>

            <p style="text-align: center; color: green;"> ${messsuccess}</p> 
            <p style="text-align: center; color: red;"> ${messerror}</p> 
            <p style="text-align: center; color: red;"> ${errorM}</p> 
            <p style="text-align: center; color: red;"> ${errorMess}</p> 
            <h3>Rating form</h3>
            <form action="rate" method="post">
                <div class="rating">
                    <select style="margin-left: -127px;" name="mentorId">
                        <option disabled selected>Select Mentor</option> 
                        <c:forEach var="m" items="${mentors}">
                            <option value="${m.idMentor}">${m.fullname}</option>
                        </c:forEach>
                    </select>

                    <!-- Change the type of the hidden input field to text -->
                    <input type="number" name="rating" hidden>
                    <i class='bx bx-star star' style="--i: 0;"></i>
                    <i class='bx bx-star star' style="--i: 1;"></i>
                    <i class='bx bx-star star' style="--i: 2;"></i>
                    <i class='bx bx-star star' style="--i: 3;"></i>
                    <i class='bx bx-star star' style="--i: 4;"></i>
                </div>
                <textarea name="opinion" cols="30" rows="5" placeholder="Your opinion..."></textarea>
                <div class="btn-group">
                    <button type="submit" class="btn submit">Submit</button>
                    <button class="btn cancel">Cancel</button>
                </div>
            </form>
        </div>

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
    </body>
</html>
