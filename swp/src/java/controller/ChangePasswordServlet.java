/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author trang
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/changePass"})
public class ChangePasswordServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        request.getRequestDispatcher("Account/changepass.jsp").forward(request, response);
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
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String username = request.getParameter("username");
    String oldPassword = request.getParameter("oldpassword");
    String newPassword = request.getParameter("newpassword");
    String confirmPassword = request.getParameter("confirm");

    DAO d = new DAO();
    Account a = d.login(username, oldPassword);

    if (a != null) {
       
        if (!newPassword.equals(oldPassword)) {
            
            if (newPassword.trim().equals(confirmPassword.trim())) {
                // Update the password
                d.updatePassword(a.getId(), newPassword);
                // Display success message
                request.setAttribute("messsucces", "Change password successfully, please sign in again!");
                request.getRequestDispatcher("Account/signin.jsp").forward(request, response);
            } else {
                // Display error message if the new password and confirm password don't match
                String err = "New password and confirm password are not the same";
                request.setAttribute("erro", err);
                request.getRequestDispatcher("Account/changepass.jsp").forward(request, response);
            }
        } else {
            // Display error message if the new password is the same as the old password
            String err = "New password must be different from the old password";
            request.setAttribute("err", err);
            request.getRequestDispatcher("Account/changepass.jsp").forward(request, response);
        }
    } else {
        // Display error message if the old password is incorrect
        String err = "Account or password is incorrect";
        System.out.println(err);
        request.setAttribute("error", err);
        request.getRequestDispatcher("Account/changepass.jsp").forward(request, response);
    }

    // Logging for debugging
    System.out.println("Username: " + username);
    System.out.println("Old Password: " + oldPassword);
    System.out.println("New Password: " + newPassword);
    System.out.println("Confirm Password: " + confirmPassword);
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
