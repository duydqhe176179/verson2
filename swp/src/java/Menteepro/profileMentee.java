/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Menteepro;

import dal.MenteeDAO;
import dal.MentorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import model.Account;
import model.Have_SKill;
import model.Mentee;
import model.Mentor;
import model.info;

/**
 *
 * @author admin
 */
@WebServlet(name = "profileMentee", urlPatterns = {"/profileMentee"})
@MultipartConfig
public class profileMentee extends HttpServlet {

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
            out.println("<title>Servlet profileMentee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profileMentee at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        if (a == null) {
            processRequest(request, response);
        } else {

            MenteeDAO dao = new MenteeDAO();

            Account account = dao.getAccountByid(a.getId());
            request.setAttribute("account", account);
            Mentee mentee = dao.getallMentee(a.getId());
//            String fileName = mentee.getAvatar(); // Default to existing avatar

//            Part filePart = request.getPart("imageprofile");
//            if (filePart != null && !filePart.getSubmittedFileName().isEmpty()) {
//                fileName = handleFileUpload(filePart);
//            }
            request.setAttribute("mentee", mentee);
            request.getRequestDispatcher("Mentee/Profile.jsp").forward(request, response);
        }

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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        if (a == null) {
            processRequest(request, response);
        } else {

            MenteeDAO dao = new MenteeDAO();
            Mentee mentee = dao.getallMentee(a.getId());
            String fileName = mentee.getAvatar();

            Part filePart = request.getPart("imageprofile");
            if (filePart != null && !filePart.getSubmittedFileName().isEmpty()) {
                fileName = handleFileUpload(filePart);
            }
            int idMentee = a.getId();

            boolean result = false;
            try {
                result = dao.updateAvatar(idMentee, fileName);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
                result = false;// Log the exception
            }
           response.sendRedirect("profileMentee");
        }
    }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
            () {
        return "Short description";
        }// </editor-fold>

    

    

    private String handleFileUpload(Part filePart) throws IOException {
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String imageDirectory = getServletContext().getRealPath("/img");

        // Create the directory if it doesn't exist
        File uploadDir = new File(imageDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Check if a file with the same name already exists and delete it
        File existingFile = new File(uploadDir, fileName);
        if (existingFile.exists()) {
            existingFile.delete();
        }

        // Save the uploaded image with the desired file name to the directory
        try ( InputStream fileInput = filePart.getInputStream()) {
            Path imagePath = Paths.get(uploadDir.getAbsolutePath(), fileName);
            Files.copy(fileInput, imagePath);
        }

        return "img/" + fileName;
    }

}
