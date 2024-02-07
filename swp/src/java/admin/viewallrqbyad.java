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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Account;
import model.Adshowreq;

/**
 *
 * @author trang
 */
@WebServlet(name = "viewallrqbyad", urlPatterns = {"/viewall"})
public class viewallrqbyad extends HttpServlet {

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
            out.println("<title>Servlet viewallrqbyad</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet viewallrqbyad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        return account != null && "Admin".equals(account.getRole());
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!isAdmin(request)) {
            // Redirect to home.jsp if not an admin
            response.sendRedirect("home.jsp");
            return;
        }

        int page = 1; // default page number
        int recordsPerPage = 6; // number of records to display per page

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        AdminDAO dao = new AdminDAO();

        String searchTerm = request.getParameter("searchTerm");
        if (searchTerm != null && !searchTerm.isEmpty()) {
            List<Adshowreq> searchResults = dao.searchAdshowreq(searchTerm);

            // Paginate the search results
            int totalRecords = searchResults.size();
            int totalPages = (totalRecords + recordsPerPage - 1) / recordsPerPage;
            int startIdx = (page - 1) * recordsPerPage;
            int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);
            List<Adshowreq> currentList = searchResults.subList(startIdx, endIdx);

            request.setAttribute("listRequest", currentList);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", page);
        } else {
            // No search term, retrieve all requests
            List<Adshowreq> listRequest = dao.getAllAdshowreq();

            int totalRecords = listRequest.size();
            int totalPages = (totalRecords + recordsPerPage - 1) / recordsPerPage;

            int startIdx = (page - 1) * recordsPerPage;
            int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);
            List<Adshowreq> currentList = listRequest.subList(startIdx, endIdx);

            List<String> statusList = dao.getAllDistinctStatus();

            request.setAttribute("statusList", statusList);
            // date 

            request.setAttribute("listRequest", currentList);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", page);
        }

        System.out.println("Forwarding to viewadmin.jsp");

// Modify this line to include the page parameter in the URL
        request.getRequestDispatcher("Admin/viewadmin.jsp?page=" + page).forward(request, response);

//        if (!isAdmin(request)) {
//            // Redirect to home.jsp if not an admin
//            response.sendRedirect("home.jsp");
//            return;
//        }
//        int page = 1; // default page number
//        int recordsPerPage = 6; // number of records to display per page
//
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//
//        AdminDAO dao = new AdminDAO();
//        List<Adshowreq> listRequest = dao.getAllAdshowreq();
//
//        int totalRecords = listRequest.size();
//        int totalPages = (totalRecords + recordsPerPage - 1) / recordsPerPage;
//
//        int startIdx = (page - 1) * recordsPerPage;
//        int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);
//        List<Adshowreq> currentList = listRequest.subList(startIdx, endIdx);
//
//        List<String> statusList = dao.getAllDistinctStatus();
//
//        request.setAttribute("statusList", statusList);
//        // date 
//
//        request.setAttribute("listRequest", currentList);
//        request.setAttribute("totalPages", totalPages);
//        request.setAttribute("currentPage", page);
//
//        System.out.println("Forwarding to viewadmin.jsp");
//
//        // Modify this line to include the page parameter in the URL
//        request.getRequestDispatcher("Admin/viewadmin.jsp?page=" + page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();

// Get parameters from the request
        String[] selectedStatusArray = request.getParameterValues("selectedStatusArray");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

// Convert the array to a List<String>
        List<String> selectedStatusList = new ArrayList<>();

// Null check for selectedStatusArray
        if (selectedStatusArray != null) {
            selectedStatusList = Arrays.asList(selectedStatusArray);
        }

// Null check and default values for startDate and endDate
        if (startDate == null || startDate.isEmpty()) {
            startDate = null; // Set to null if empty or adjust based on your database schema
        }
        if (endDate == null || endDate.isEmpty()) {
            endDate = null; // Set to null if empty or adjust based on your database schema
        }

        System.out.println("Selected Status List: " + selectedStatusList);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);

        List<Adshowreq> adshowreqList;

// Check if both status array and date range are empty
        if (selectedStatusList.isEmpty() && (startDate == null || endDate == null)) {
            // Fetch all Adshowreq if both status array and date range are empty
            System.out.println("Fetching all Adshowreq");
            adshowreqList = dao.getAllAdshowreq();
        } else if (selectedStatusList.isEmpty() && startDate != null && endDate != null) {
            // Fetch Adshowreq based on date range only
            System.out.println("Fetching Adshowreq based on date range only");
            adshowreqList = dao.checkdate(startDate, endDate);
        } else {
            // Fetch Adshowreq based on multiple statuses and date range
            System.out.println("Fetching Adshowreq based on multiple statuses and date range");
            adshowreqList = dao.getMulStatus(selectedStatusList, startDate, endDate);
        }

        List<String> statusList = dao.getAllDistinctStatus();

        System.out.println("Status List: " + statusList);
        System.out.println("Result List Size: " + adshowreqList.size());

        request.setAttribute("statusList", statusList);
        request.setAttribute("listRequest", adshowreqList);
        request.getRequestDispatcher("Admin/viewadmin.jsp").forward(request, response);

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
