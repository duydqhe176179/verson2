/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import admin.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.SkillMentor;

/**
 *
 * @author Admin
 */
@WebServlet(name = "updateSkill", urlPatterns = {"/updateSkill"})
@MultipartConfig
public class updateSkill extends HttpServlet {

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
            out.println("<title>Servlet updateSkill</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateSkill at " + request.getContextPath() + "</h1>");
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
        AdminDAO admindao = new AdminDAO();
        SkillMentor s = admindao.getSkillById(Integer.parseInt(request.getParameter("idSkill")));

        request.setAttribute("skill", s);

        request.getRequestDispatcher("Admin/updateSkill.jsp").forward(request, response);
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
        AdminDAO admin = new AdminDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        SkillMentor skill = admin.getSkillById(id);
        String title = request.getParameter("title");

        String fileName = "";
        if (request.getPart("image") != null && !request.getPart("image").getSubmittedFileName().isEmpty()) {
            Part filePart = request.getPart("image");
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
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
            fileName = "img/" + fileName;
        } else {
            fileName = skill.getImage();
        }
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String status=request.getParameter("status");
        System.out.println(status);
        admin.updateSkill(id, title, fileName, name, description, status);
        response.sendRedirect("admin");
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
