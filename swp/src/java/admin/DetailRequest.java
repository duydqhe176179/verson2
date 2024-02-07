package admin;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.ReDetail;

@WebServlet(name = "DetailRequest", urlPatterns = {"/detailreq"})
public class DetailRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         AdminDAO dao = new AdminDAO();

    // Get the ID from the request parameter
    String idMentee = request.getParameter("id");

    // Fetch all requests for the specific idMentee
    List<ReDetail> requestList = dao.getAllRequestsByIdMentee(Integer.parseInt(idMentee));

    // Set the requestList as an attribute in the request
    request.setAttribute("requestList", requestList);

    // Forward the request to the JSP page
    request.getRequestDispatcher("Admin/Requestdetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle post requests if needed
    }

    @Override
    public String getServletInfo() {
        return "DetailRequest Servlet";
    }
}
