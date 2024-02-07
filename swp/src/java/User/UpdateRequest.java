/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package User;

import dal.MentorDAO;
import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Mentor;
import model.Skill;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="UpdateRequest", urlPatterns={"/updatereq"})
public class UpdateRequest extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateRequest</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRequest at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        MentorDAO dao = new MentorDAO();
        List<Skill> list1 = dao.getSkill();
        request.setAttribute("Skill", list1);
        List<Mentor> listMentor1 = dao.getMentor();
        
        String idRequest=request.getParameter("idrequest");
        System.out.println(idRequest);
        request.setAttribute("idRequest", idRequest);
        
        request.setAttribute("MentorName", listMentor1);
        
        request.getRequestDispatcher("view/updatereq.jsp").forward(request, response);
        System.out.println(list1.size());
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String idr = request.getParameter("idRequest");
        String title = request.getParameter("title");
        System.out.println(idr);
        String des = request.getParameter("sdep");
        String dhour = request.getParameter("hour");
        String ddate = request.getParameter("date");
        String skill = request.getParameter("skills");
        String mentorName = request.getParameter("mentorname");
        int idMentor = Integer.parseInt(mentorName);
        String status = request.getParameter("status");
        RequestDAO rq = new RequestDAO();
        rq.UpdateRequest(idr, title, des, dhour, ddate, skill, idMentor, status);
        response.sendRedirect("listrequest");
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
