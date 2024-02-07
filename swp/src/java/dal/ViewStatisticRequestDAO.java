/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.MentorStatistic;
import model.Request;

/**
 *
 * @author ADMIN-PC
 */
public class ViewStatisticRequestDAO extends DBContext {

    private List<Request> listRequest = new ArrayList<>();
    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;

    public List<Request> getAllRequest() {
        String query = "SELECT idRequest, idMentee, idMentor, title, content, skill, status, deadlineDate, deadlineHour FROM request";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();

            while (rs.next()) {
                int idRequest = rs.getInt("idRequest");
                int idMentee = rs.getInt("idMentee");
                int idMentor = rs.getInt("idMentor");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String skill = rs.getString("skill");
                String status = rs.getString("status");
                String deadlineDate = rs.getString("deadlineDate");
                BigDecimal deadlineHour = rs.getBigDecimal("deadlineHour");

                listRequest.add(new Request(idRequest, idMentee, idMentor, title, content, skill, status, deadlineDate, deadlineHour));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listRequest;
    }

    public int getAcceptedRequestCountByIdMentor(int mentorId) {
        int acceptedRequestCount = 0;
        String query = "SELECT COUNT(*) AS AcceptedRequestCount FROM request WHERE status = 'Processing' AND idMentor = ?";

        try {
            if (conn == null) {
                conn = new DBContext().connection;
            }

            stm = conn.prepareStatement(query);
            stm.setInt(1, mentorId);
            rs = stm.executeQuery();

            if (rs.next()) {
                acceptedRequestCount = rs.getInt("AcceptedRequestCount");
            }
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error closing resources: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return acceptedRequestCount;
    }

    public MentorStatistic getMentorStatistics(int mentorId) {
        int processingRequestCount = 0;
        int openRequestCount = 0;
        int cancelRequestCount = 0;
        double cancelRatio = 0.0;
        double closedRatio = 0.0;
        double averageRating = 0.0;

        String queryProcessing = "SELECT COUNT(*) AS ProcessingRequestCount FROM dbo.request WHERE status = 'Processing' AND idMentor = ?";
        String queryOpen = "SELECT COUNT(*) AS OpenRequestCount FROM dbo.request WHERE status = 'Open' AND idMentor = ?";
        String queryCancel = "SELECT COUNT(*) AS CancelRequestCount FROM dbo.request WHERE status = 'Cancel' AND idMentor = ?";
        String queryCancelRatio = "SELECT (COUNT(CASE WHEN status = 'Cancel' THEN 1 END) * 100.0) / COUNT(*) AS CancelRatio FROM dbo.request WHERE idMentor = ?";
        String queryClosedRatio = "SELECT (COUNT(CASE WHEN status = 'Closed' THEN 1 END) * 100.0) / COUNT(*) AS ClosedRatio FROM dbo.request WHERE idMentor = ?";
        String queryAverageRating = "SELECT AVG(star) AS AverageRating FROM dbo.rate WHERE idMentor = ?";

        try {
            // Khoi tao du lieu db
            conn = new DBContext().connection;

            stm = conn.prepareStatement(queryProcessing);
            stm.setInt(1, mentorId);
            rs = stm.executeQuery();

            if (rs.next()) {
                processingRequestCount = rs.getInt("ProcessingRequestCount");
            }

            stm = conn.prepareStatement(queryOpen);
            stm.setInt(1, mentorId);
            rs = stm.executeQuery();

            if (rs.next()) {
                openRequestCount = rs.getInt("OpenRequestCount");
            }

            stm = conn.prepareStatement(queryCancel);
            stm.setInt(1, mentorId);
            rs = stm.executeQuery();

            if (rs.next()) {
                cancelRequestCount = rs.getInt("CancelRequestCount");
            }

            stm = conn.prepareStatement(queryCancelRatio);
            stm.setInt(1, mentorId);
            rs = stm.executeQuery();

            if (rs.next()) {
                cancelRatio = rs.getDouble("CancelRatio");
            }

            stm = conn.prepareStatement(queryClosedRatio);
            stm.setInt(1, mentorId);
            rs = stm.executeQuery();

            if (rs.next()) {
                closedRatio = rs.getDouble("ClosedRatio");
            }

            // Calculate Average Rating
            stm = conn.prepareStatement(queryAverageRating);
            stm.setInt(1, mentorId);
            rs = stm.executeQuery();

            if (rs.next()) {
                averageRating = rs.getDouble("AverageRating");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return new MentorStatistic(processingRequestCount, openRequestCount, cancelRequestCount, cancelRatio, closedRatio, averageRating);
    }

    public static void main(String[] args) {
        try {
            ViewStatisticRequestDAO dao = new ViewStatisticRequestDAO();
            int mentorId = 1;
            MentorStatistic mentorStats = dao.getMentorStatistics(mentorId);
            System.out.println("Processing Request Count: " + mentorStats.getProcessingRequestCount());
            System.out.println("Open Request Count: " + mentorStats.getOpenRequestCount());
            System.out.println("Cancel Request Count: " + mentorStats.getCancelRequestCount());
            System.out.println("Cancel Ratio: " + mentorStats.getCancelRatio() + "%");
            System.out.println("Closed Ratio: " + mentorStats.getClosedRatio() + "%");
            System.out.println("Avat: " + mentorStats.getAverageRating());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
