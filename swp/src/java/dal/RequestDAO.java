package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Request;

/**
 *
 * @author anhdu
 */
public class RequestDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

 public boolean createRequest(Request request) {
    String query = "INSERT INTO request (idMentee, idMentor, title, content, skill, status, deadlineDate, deadlineHour) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection connection = this.connection;
         PreparedStatement pstmt = connection.prepareStatement(query)) {

        pstmt.setInt(1, request.getIdMentee());
        pstmt.setInt(2, request.getIdMentor());
        pstmt.setString(3, request.getTitle());
        pstmt.setString(4, request.getContent());
        pstmt.setString(5, request.getSkill());
        pstmt.setString(6, request.getStatus());
        pstmt.setString(7, request.getDeadlineDate());
        pstmt.setBigDecimal(8, request.getDeadlineHour());
        
        pstmt.executeUpdate();
    } catch (SQLException e) {
        // Handle database access or SQL exception
        e.printStackTrace(); // Log the exception details
    }
    return true;
}



    public boolean updateRequest(Request request) {
        String query = "UPDATE request SET "
                + "idMentee = ?, "
                + "title = ?, "
                + "content = ?, "
                + "skill = ?, "
                + "status = ?, "
                + "deadlineDate = ?, "
                + "deadlineHour = ? "
                + "WHERE idRequest = ?";

        try ( Connection connection = this.connection;  
            PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, request.getIdMentee());
            pstmt.setString(2, request.getTitle());
            pstmt.setString(3, request.getContent());
            pstmt.setString(4, request.getSkill());
            pstmt.setString(5, request.getStatus());
pstmt.setString(6, request.getDeadlineDate());
            pstmt.setBigDecimal(7, request.getDeadlineHour());;
            pstmt.setInt(8, request.getIdRequest());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace();
        }
        return false;
    }

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String query = "SELECT * FROM request";

        try ( Connection connection = this.connection;  
            PreparedStatement pstmt = connection.prepareStatement(query);  ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                Request request = mapResultSetToRequest(resultSet);
                requests.add(request);
            }
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace();
        }
        return requests;
    }

    public Request getRequestById(int idRequest) {
        String query = "SELECT * FROM request WHERE idRequest = ?";

        try ( Connection connection = this.connection;  
            PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, idRequest);

            try ( ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToRequest(resultSet);
                }
            }
        } catch (SQLException e) {
            // Handle database access or SQL exception
            e.printStackTrace();
        }
        return null;
    }

    private Request mapResultSetToRequest(ResultSet resultSet) throws SQLException {
        return new Request(
                resultSet.getInt("idRequest"),
                resultSet.getInt("idMentee"),
                resultSet.getInt("idMentor"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getString("skill"),
                resultSet.getString("status"),
                resultSet.getString("deadlineDate"),
                resultSet.getBigDecimal("deadlineHour")
        );
    }
    
    public boolean UpdateRequest(String idr, String title, String des, String hour, String date, String skill, int idMentor, String status) {
        Connection conn = null;
        String query = "UPDATE [dbo].[request]\n"
                + "   SET \n"
                + "      [idMentor] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[content] = ?\n"
                + "      ,[skill] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[deadline] = ?\n"
                + "      ,[hour] = ?\n"
                + " WHERE idRequest = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, idMentor);
            stm.setString(2, title);
            stm.setString(3, des);
            stm.setString(4, skill);
            stm.setString(5, status);
            stm.setString(6, date);
            stm.setString(7, hour);
            stm.setString(8, idr);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Assuming you have a Request object ready for testing
        Request testRequest = new Request();
        testRequest.setIdMentee(5);
        testRequest.setIdMentor(1);
        testRequest.setTitle("Test Request");
        testRequest.setContent("This is a test request.");
        testRequest.setSkill("Java");
        testRequest.setStatus("Open");
        testRequest.setDeadlineDate("2022-02-28");
        testRequest.setDeadlineHour(BigDecimal.valueOf(15.2));

        // Assuming you have an instance of RequestDAO
        RequestDAO dao = new RequestDAO();

        // Call the createRequest method and handle the result
        try {
            dao.createRequest(testRequest);
            System.out.println("Request created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating request: " + e.getMessage());
        }
    }

}
