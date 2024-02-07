/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Adshowreq;

/**
 *
 * @author trang
 */
@WebServlet(name = "Search", urlPatterns = {"/search"})
public class Search extends HttpServlet {

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
            out.println("<title>Servlet Search</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Search at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("viewall").forward(request, response);
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
//        String searchTerm = request.getParameter("searchTerm");
//        int currentPage = 1;
//
//        // Get the current page parameter
//        String pageParam = request.getParameter("page");
//        if (pageParam != null && !pageParam.isEmpty()) {
//            currentPage = Integer.parseInt(pageParam);
//        }
//
//        AdminDAO dao = new AdminDAO();
//
//        if (searchTerm != null && !searchTerm.isEmpty()) {
//            List<Adshowreq> searchResults = dao.searchAdshowreq(searchTerm);
//
//            // Paginate the search results
//            int recordsPerPage = 6;
//            int totalRecords = searchResults.size();
//            int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
//            int startIdx = (currentPage - 1) * recordsPerPage;
//            int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);
//            List<Adshowreq> paginatedResults = searchResults.subList(startIdx, endIdx);
//
//            request.setAttribute("listRequest", paginatedResults);
//            request.setAttribute("totalPages", totalPages);
//            request.setAttribute("currentPage", currentPage);
//        } else {
//            // No search term, retrieve all requests
//            List<Adshowreq> allRequests = dao.getAllAdshowreq();
//            request.setAttribute("listRequest", allRequests);
//        }
//
//        request.getRequestDispatcher("Admin/viewadmin.jsp").forward(request, response);
        //request.getRequestDispatcher("viewall").forward(request, response);
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
