/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Request;

/**
 *
 * @author ADMIN
 */
public class StatisticRequest extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    dal.ListRequest req = new dal.ListRequest();

    public int getTotalRequests(List<Request> listRequest) {
        return listRequest.size();
    }

    // Method to calculate the total number of hours
    public float getTotalHours(List<Request> listRequest) {
        float totalHours = 0;
        for (Request request : listRequest) {
            totalHours += request.getHour();
        }
        return totalHours;
    }

    // Method to calculate the total number of mentors with requests
    public Map<Integer, Integer> getTotalMentors(List<Request> listRequest) {
        Map<Integer, Integer> mentorCounts = new HashMap<>();
        for (Request request : listRequest) {
            int mentorCount = mentorCounts.getOrDefault(request.getIdMentor(), 0);
            mentorCounts.put(request.getIdMentor(), mentorCount + 1);
        }
        return mentorCounts;
    }

    // Method to get the names of mentors for each mentor in the list
    public Map<Integer, String> getTotalMentorsName(List<Request> listRequest) {
        Map<Integer, String> mentorNames = new HashMap<>();
        StatisticRequest sr = new StatisticRequest(); // Assuming this class exists and has a method to get mentor names

        for (Request request : listRequest) {
            int idMentor = request.getIdMentor();
            String mentorName = sr.getMentorNameById(idMentor);
            mentorNames.put(idMentor, mentorName);
        }

        return mentorNames;
    }

    public String getMentorNameById(int idMentor) {
        Connection conn = null;
        String mentorName = null;
        String query = "SELECT fullname from mentor where idMentor = ? ";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            if (rs.next()) {
                mentorName = rs.getString("fullname");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mentorName;
    }

    public static void main(String[] args) {
        // Assuming you have a list of Request objects to test with
        dal.ListRequest req = new dal.ListRequest();
        List<Request> listRequest1 = req.ListRequestById(4);

        // Create an instance of ListRequest
        StatisticRequest listRequestInstance = new StatisticRequest();

        // Test getTotalRequests method
        int totalRequests = listRequestInstance.getTotalRequests(listRequest1);
        System.out.println("Total Requests: " + totalRequests);

        // Test getTotalHours method
        float totalHours = listRequestInstance.getTotalHours(listRequest1);
        System.out.println("Total Hours: " + totalHours);

        // Test getTotalMentors method
        Map<Integer, Integer> mentorCounts = listRequestInstance.getTotalMentors(listRequest1);
        System.out.println("Mentor Counts: " + mentorCounts);

        // Assuming you have a method to get mentor names in your StatisticRequest class
        // Test getTotalMentorsName method
        Map<Integer, String> mentorNames = listRequestInstance.getTotalMentorsName(listRequest1);
        System.out.println("Mentor Names: " + mentorNames);
    }
}
