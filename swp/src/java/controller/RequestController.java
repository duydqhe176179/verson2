/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.MenteeDAO;
import dal.MentorDAO;
import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Mentor;
import model.Request;

/**
 *
 * @author admin
 */
@WebServlet(name = "RequestController", urlPatterns = {"/Request"})
public class RequestController extends HttpServlet {

    private RequestDAO requestDAO;

    public void init() {
        requestDAO = new RequestDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                listRequests(request, response);
                break;
            case "create":
                showRequestForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listRequests(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createRequest(request, response);
                break;
            case "update":
                updateRequest(request, response);
                break;
            default:
                listRequests(request, response);
        }
    }

    private void listRequests(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Request> requests = requestDAO.getAllRequests();
        request.setAttribute("requests", requests);
        request.getRequestDispatcher("request-list.jsp").forward(request, response);
    }

    private void showRequestForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Account account = (Account) request.getSession().getAttribute("account");
        if (account == null) {
            response.sendRedirect("signin");
            return;
        }
        MentorDAO dao = new MentorDAO();
        List<Mentor> mentor = dao.getListOfMentors();
        request.setAttribute("listMentor", mentor);


        request.getRequestDispatcher("view/create-request.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRequest = Integer.parseInt(request.getParameter("idRequest"));
        Request requestToEdit = requestDAO.getRequestById(idRequest);
        request.setAttribute("request", requestToEdit);
        request.getRequestDispatcher("edit-request.jsp").forward(request, response);
    }

    private void createRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("Not available");
        try {
            // Retrieve form data
            int idMentor = Integer.parseInt(request.getParameter("idMentor"));
            String title = request.getParameter("title");
            String deadlineDateStr = request.getParameter("deadlineDate");
            String deadlineHourStr = request.getParameter("deadlineHour");
            String content = request.getParameter("content");
            String[] skills = request.getParameterValues("skills");

            // Assuming you have a method to get the current Mentee ID
            Account account = (Account) request.getSession().getAttribute("account");
            int idMentee = new MenteeDAO().getMenteeByAccountId(account.getId()).getIdMentee();

            // Convert deadline date and hour to java.util.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //String deadlineDate = dateFormat.format(deadlineDateStr);
            BigDecimal deadlineHour = new BigDecimal(deadlineHourStr);

            // Create a new Request object
            Request newRequest = new Request(0, idMentee, idMentor, title, content, String.join(", ", skills), "Open", deadlineDateStr, deadlineHour);
System.out.println(newRequest.toString());

            // Save the new request to the database
            RequestDAO requestDAO1 = new RequestDAO();
            requestDAO1.createRequest(newRequest);
            String msg= "success";
            request.setAttribute("msg","success");
            request.getRequestDispatcher("view/create-request.jsp").forward(request, response);
//        if (result) {
//            // Redirect to a success page
//            response.sendRedirect("Request?action=list&success");
//        } else {
//            // Handle error case
//            response.sendRedirect("Request?action=create&fail");
//        }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Request?action=create&fail");
        }

    }

    private void updateRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve form data
            int idRequest = Integer.parseInt(request.getParameter("idRequest"));
            int idMentor = Integer.parseInt(request.getParameter("idMentor"));
            String title = request.getParameter("title");
            String deadlineDateStr = request.getParameter("deadlineDate");
            String deadlineHourStr = request.getParameter("deadlineHour");
            String content = request.getParameter("content");
            String[] skills = request.getParameterValues("skills");
            String status = request.getParameter("status");

            // Convert deadline date and hour to java.util.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date deadlineDate = dateFormat.parse(deadlineDateStr);
            BigDecimal deadlineHour = new BigDecimal(deadlineHourStr);
            // Assuming you have a method to get the current Mentee ID
            Account account = (Account) request.getSession().getAttribute("account");
//            int idMentee = new MenteeDAO().getMenteeByAccountId(account.getId()).getIdMentee();

            // Create an updated Request object
//            Request updatedRequest = new Request(idRequest, idMentee, idMentor, title, content, String.join(", ", skills), "Open", deadlineDate, deadlineHour);            // Update the request in the database
//            if (requestDAO.updateRequest(updatedRequest)) {
//                response.sendRedirect("success.jsp"); // Redirect to a success page
//            } else {
//                // Handle error case
//                response.getWriter().println("Error updating request");
//            }
        } catch (ParseException e) {
            // Handle parsing error
            response.getWriter().println("Error parsing date");
        }
    }

}
