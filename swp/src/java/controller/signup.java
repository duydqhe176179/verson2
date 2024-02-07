/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import CheckDb.Checkdb;
import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Account;
import EmailDAO.Email;
import model.Signup;

/**
 *
 * @author Admin
 */
public class signup extends HttpServlet {

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
            out.println("<title>Servlet signup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Account/signup.jsp").forward(request, response);
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
        Checkdb check = new Checkdb();
        DAO dao = new DAO();
        String role = request.getParameter("role");
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");

        System.out.println(pass);
        System.out.println(repass);
        System.out.println(pass.equals(repass));

        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        Signup signup = new Signup(role, user, pass, repass, email, fullname, phone, birth, address, gender);

        String err = "";
        LocalDateTime registrationTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String registerDate = registrationTime.format(formatter);

        if (!check.IsUserExist(user)) { // nêu tài khoan dã tôn tai

            if (!check.isEmailUsed(email)) { // neu email da ton tai

                if (repass.equals(pass)) {
                    dao.addAccount(user, pass, role, email);
                    Account a = dao.login(user, pass);
                    if (role.equalsIgnoreCase("Mentor")) {
                        dao.addMentor(a.getId(), fullname, phone, birth, gender, address, registerDate);
                    } else {
                        dao.addMentee(a.getId(), fullname, birth, phone, gender, registerDate, address);
                        //thieu gui email xac nhan tai khoan
                    }
//                Email emailDAO = new Email();
//                String verify = emailDAO.verifyMail();
//                emailDAO.sendEmail(email, verify);

                    HttpSession session = request.getSession();
                    session.setAttribute("account", a);
//                session.setAttribute("verify", verify);

                    request.getRequestDispatcher("sendEmailVerify").forward(request, response);

                } else {
                    err += "password and re-password not same";
                    request.setAttribute("err", err);
                    request.setAttribute("signup", signup);
                    request.getRequestDispatcher("Account/signup.jsp").forward(request, response);
                }
            } else {
                err += "Email already exists";
                request.setAttribute("err", err);
                request.setAttribute("signup", signup);
                request.getRequestDispatcher("Account/signup.jsp").forward(request, response);
            }

        } else {
            err += "Username already exists";
            request.setAttribute("err", err);
            request.setAttribute("signup", signup);
            request.getRequestDispatcher("Account/signup.jsp").forward(request, response);
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
