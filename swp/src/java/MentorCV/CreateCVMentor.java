/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package MentorCV;

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
import model.Mentor;
import model.SkillMentor;

/**
 *
 * @author admin
 */

@WebServlet(name="CreateCVMentor", urlPatterns={"/createcv"})
@MultipartConfig
public class CreateCVMentor extends HttpServlet {
   
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
            out.println("<title>Servlet CreateCVMentor</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCVMentor at " + request.getContextPath () + "</h1>");
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        if (a == null) {
            processRequest(request, response);
        } else {

            MentorDAO dao = new MentorDAO();
            Mentor list = dao.getIDMentor(a.getId());
            request.setAttribute("mentor", list);
            System.out.println(list);
            List<Have_SKill> hskill = dao.getidhaveskill(a.getId());
            System.out.println(hskill);
            request.setAttribute("cf", hskill);

            Account account = dao.getAccountByid(a.getId());
            request.setAttribute("cx", account);
            List<SkillMentor> skill = dao.getAllskill();
            request.setAttribute("skill", skill);
            System.out.println(skill);

            request.getRequestDispatcher("Mentor/CreateCV.jsp").forward(request, response);
        }
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
       HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");

        MentorDAO dao = new MentorDAO();
        Mentor mentor = dao.getIDMentor(a.getId());

        String fileName = mentor.getAvatar(); // Default to existing avatar

        Part filePart = request.getPart("image");
        if (filePart != null && !filePart.getSubmittedFileName().isEmpty()) {
            fileName = handleFileUpload(filePart);
        }

        int idMentor = a.getId();
        String fullname = request.getParameter("uname");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("date");
        String sex = request.getParameter("gender");
        String address = request.getParameter("address");
        String profession = request.getParameter("pwd");
        String pro_introduc = request.getParameter("intro");
        String archivement_descition = request.getParameter("achivement");
        String framework = request.getParameter("framework");
        String experience = request.getParameter("experience");
        String education = request.getParameter("education");
        String myservice = request.getParameter("service");
        String[] idSkill = request.getParameterValues("skills");
        //dao.deleteMentor(idMentor);

//        for (String selectedSkill : idSkill) {
//            dao.addHave_Skill(new Have_SKill(a.getId(), Integer.parseInt(selectedSkill)));
//        }
        if (idSkill != null && idSkill.length > 0) {
            dao.deleteMentorbyhaveskill(idMentor);
            for (String selectedSkill : idSkill) {
                dao.addHave_Skill(new Have_SKill(a.getId(), Integer.parseInt(selectedSkill)));
            }
        } else {
            // Assuming you want to add a default skill if no skills are selected
         dao.deleteMentorbyhaveskill(idMentor);
        }

        // Process the selected skills
        boolean result = false;
        try {
            result = dao.updateCV(idMentor, fullname, fileName, phone, dob, sex, address, profession, pro_introduc, archivement_descition, framework, experience, education, myservice, idSkill);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;// Log the exception
        }

        request.setAttribute("mess", "Update successfully!");

        response.sendRedirect("Succesfull.jsp");

        

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
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
