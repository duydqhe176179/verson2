/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Mentee;
import model.Mentor;
import model.Request;
import model.Skill;
import model.StaticMentee;

/**
 *
 * @author admin
 */
public class MenteeDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Mentee> mentee = new ArrayList<>();
    List<StaticMentee> list = new ArrayList<>();
    public Mentee getMenteeByAccountId(int idAccount) {
        String query = "SELECT m.* FROM mentee m " +
                       "JOIN account a ON m.idMentee = a.idAccount " +
                       "WHERE a.idAccount = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idAccount);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToMentee(resultSet);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving mentee by accountId: " + e.getMessage());
        }
        return null;
    }

    private Mentee mapResultSetToMentee(ResultSet resultSet) throws Exception {
        return new Mentee(
                resultSet.getInt("idMentee"),
                resultSet.getString("fullname"),
                resultSet.getString("avatar"),
                resultSet.getString("story"),
                resultSet.getString("dob"),
                resultSet.getString("phone"),
                resultSet.getString("sex"),
                resultSet.getString("experience"),
                resultSet.getString("registerDate"),
                resultSet.getString("address")
        );
    }
    public boolean updateAvatar(int idMentee, String avatar) {
        try {
            String strUPDATE = "UPDATE [dbo].[mentee]\n"
                    + "   SET \n"
                    + "     \n"
                    + "      [avatar] = ?\n"
                    + "      \n"
                    + "     \n"
                    + " WHERE idMentee=?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, avatar);
            stm.setInt(2, idMentee);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public List<StaticMentee> getStaticMetee() {
        try {

            String strSelect = "SELECT\n"
                    + "    m.fullname as FullName,\n"
                    + "    a.username as UserName,\n"
                    + "    COUNT(r.idRequest) as NumRequests,\n"
                    + "    SUM(r.hour) AS TotalHours,\n"
                    + "    COUNT(DISTINCT r.skill) AS TotalSkills\n"
                    + "FROM\n"
                    + "    mentee m\n"
                    + "INNER JOIN\n"
                    + "    account a ON m.idMentee = a.idAccount\n"
                    + "LEFT JOIN\n"
                    + "    request r ON m.idMentee = r.idMentee\n"
                    + "GROUP BY\n"
                    + "    m.fullname, a.username\n"
                    + "ORDER BY\n"
                    + "    m.fullname;";

            stm = connection.prepareStatement(strSelect);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String FullName = rs.getString(1);
                String UserName = rs.getString(2);
                int NumRequests = rs.getInt(3);
                float TotalHours = rs.getFloat(4);
                int totalskill  =rs.getInt(5);
                StaticMentee a = new StaticMentee(FullName, UserName, NumRequests, TotalHours,totalskill);
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean updatePMentee(int idMentee, String fullname, String dob, String sex, String address) {
        try {
            String strUPDATE = "UPDATE [dbo].[mentee]\n"
                    + "   SET \n"
                    + "      [fullname] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[sex] = ?\n"
                    + "      ,[address] = ?\n"
                    + " WHERE idMentee = ?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, fullname);
            stm.setString(2, dob);
            stm.setString(3, sex);
            stm.setString(4, address);
            stm.setInt(5, idMentee);
            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public List<Mentee> getlistallMentee() {
        try {
            String strSelect = "select * from Mentee \n";

            stm = connection.prepareStatement(strSelect);

            rs = stm.executeQuery();
            while (rs.next()) {
                int IdMentee = rs.getInt(1);
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String story = rs.getString(4);
                String dob = rs.getString(5);
                String phone = rs.getString(6);
                String sex = rs.getString(7);
                String experience = rs.getString(8);
                String registerDate = rs.getString(9);
                String address = rs.getString(10);

                Mentee a = new Mentee(IdMentee, fullname, avatar, story, dob, phone, sex, experience, registerDate, address);
                mentee.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return mentee;
    }

    public Mentee getallMentee(int idMentee) {
        try {
            String strSelect = "select * from Mentee \n"
                    + "  where idMentee=?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, idMentee);
            rs = stm.executeQuery();
            while (rs.next()) {
                int IdMentee = rs.getInt(1);
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String story = rs.getString(4);
                String dob = rs.getString(5);
                String phone = rs.getString(6);
                String sex = rs.getString(7);
                String experience = rs.getString(8);
                String registerDate = rs.getString(9);
                String address = rs.getString(10);

                Mentee a = new Mentee(IdMentee, fullname, avatar, story, dob, phone, sex, experience, registerDate, address);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    

    public static void main(String[] args) {
        MenteeDAO cv = new MenteeDAO();
        // System.out.println(cv.updateCV(1, "c", "anh12.jpg", "0988722722", "2022-2-2", "Male", "d", "d", "d", "d", "d", "D", "d", "d", new String[]{"1", "2"}));
        //  System.out.println(cv.addHave_Skill(new Have_SKill(1, 2)));
        // System.out.println(cv.updatePMentee(4, "Tran Thanh Binh", "2023-4-19", "Male", "Ninh Binh"));
        System.out.println(cv.getStaticMetee());
//        
    }

    public Account getAccountByid(int idAccount) {
        try {
            String strSelect = "SELECT * FROM dbo.account WHERE idAccount = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String user = rs.getString(2);
                String email = rs.getString(3);
                String pass = rs.getString(4);
                String role = rs.getString(5);
                int confirm = rs.getInt(6);

                Account a = new Account(id, user, email, pass, role, confirm);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
