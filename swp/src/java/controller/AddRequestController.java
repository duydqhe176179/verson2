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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import model.Account;
import model.Mentor;
import model.Request;

/**
 *
 * @author ADMIN-PC
 */
public class AddRequestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Retrieve parameters from the request
            int idMentor = Integer.parseInt(request.getParameter("idMentor"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String[] skills = request.getParameterValues("skills");
            String deadlineDate = request.getParameter("deadlineDate");
            BigDecimal deadlineHour = new BigDecimal(request.getParameter("deadlineHour"));
            Account account = (Account) request.getSession().getAttribute("account");
            int idMentee = new MenteeDAO().getMenteeByAccountId(account.getId()).getIdMentee();
            // Create a Request object
            Request newRequest = new Request(0, idMentee, idMentor, title, content, String.join(", ", skills), "Open", deadlineDate, deadlineHour);
            if (new RequestDAO().createRequest(newRequest)) {
                response.sendRedirect("Request?action=create&success");
            } else {
                // Handle error case
                response.sendRedirect("Request?action=create&fail");
            }
        } catch (Exception e) {
            // Handle parsing error
            response.sendRedirect("Request?action=create&fail");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
