<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Admin Dashboard | By Code Info</title>
        <link rel="stylesheet" href="css/viewadmin-style.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
    </head>

    <body style="font-family: verdana, geneva, sans-serif;">
        <header class="header">
            <a href="#" style="text-decoration: none; color: black; font-size: 32px; font-weight: bold;">Admin </a>
            <div class="logo">
                <div class="search_box">
                    <form action="viewall" method="post">
                        <input type="text" name="searchTerm" placeholder="Search Here" value="${param.searchTerm}">
                        <input type="hidden" name="page" value="${currentPage}" />
                        <!-- Include other filter parameters as needed -->
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
        </header>

        <div class="container">
            <div class="main-body">
                <h2>Dashboard</h2>
                <div style="height: 270px;" class="promo_card">
                    <h1>VIEW ALL</h1>   
                    <form method="post" action="viewall" id="combinedFilterForm" onsubmit="return submitCombinedForm()">
                        <div class="checkstaus">

                            <c:forEach var="s" items="${statusList}">
                                <input type="checkbox" name="selectedStatusArray" value="${s}" id="${s}" ${selectedStatusArray != null && Arrays.asList(selectedStatusArray).contains(s) ? 'checked' : ''} />
                                <label for="${s}">${s}</label><br/>
                            </c:forEach>
                        </div>

                        <div class="checkdate">
                            <div class="input-date">
                                <label for="startDate">Start Date:</label>
                                <input type="date" name="startDate" id="startDate" value="${param.startDate}" onchange="submitCombinedForm()">

                                <label for="endDate">End Date:</label>
                                <input type="date" name="endDate" id="endDate" value="${param.endDate}" onchange="submitCombinedForm()">
                            </div>
                        </div>

                        <button type="submit"><i class="fa fa-search"></i> Filter</button>
                    </form>


                </div>
                <!-- Display selected dates -->
                <div id="result"></div>

                <!-- Pagination Links -->
                <div class="pagination">
                    <c:if test="${totalPages > 1}">
                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <c:url value="viewall" var="paginationUrl">
                                <c:param name="page" value="${i}" />
                            </c:url>
                            <a href="${paginationUrl}" class="${i == currentPage ? 'active' : ''}">${i}</a>
                        </c:forEach>
                    </c:if>
                </div>

                <div class="history_lists">
                    <div class="list1">
                        <!-- Your existing content -->
                        <table>
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>ID</th>
                                    <th>Account</th>
                                    <th>Title</th>
                                    <th>Content</th>
                                    <th>Skill</th>
                                    <th>Start date</th>
                                    <th>End date</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="r" items="${listRequest}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>
                                            <!-- Assuming you want to link to the detail page -->
                                            <a href="detailreq?id=${r.idMentee}" style="text-decoration: none; color: red;">${r.idMentee}</a>
                                        </td>
                                        <td>${r.username}</td>
                                        <td>${r.title}</td>
                                        <td>${r.content}</td>
                                        <td>${r.skill}</td>
                                        <td>${r.startdate}</td>
                                        <td>${r.deadline}</td>
                                        <td>${r.status}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function filterByStatus() {
                document.getElementById("filterForm").action = "viewall";
                document.getElementById("filterForm").method = "get";
                return true;
            }

            function submitDateForm() {
                // JavaScript validation for date fields
                var startDate = document.getElementById("startDate").value;
                var endDate = document.getElementById("endDate").value;

                if (startDate > endDate) {
                    alert("Start date should be before or equal to end date.");
                    return false;
                }

                // Display selected dates
                document.getElementById("result").innerHTML = "Start Date: " + startDate + "<br>End Date: " + endDate;

                document.getElementById("dateForm").action = "viewall";
                document.getElementById("dateForm").method = "post";
                document.getElementById("dateForm").submit();
                return true;
            }
            function submitCombinedForm() {
                document.getElementById('combinedFilterForm').click();
            }
            function submitCombinedForm() {
                // Your existing form submission logic

                // Display selected filter values
                updateSelectedFilters();
            }


            }
        </script>
    </body>

</html>
