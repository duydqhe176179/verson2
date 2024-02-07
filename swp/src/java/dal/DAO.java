/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Mentor;
import model.Rate;

import model.Request;
import model.Skill;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Account> listAccount = new ArrayList<>();
    List<Skill> listAllSkill = new ArrayList<>();

    public Account login(String username, String password) {
        String query = "SELECT *"
                + "FROM account "
                + "WHERE username = ? AND password = ?";

        try ( PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int idAccount = resultSet.getInt(1);
                String user = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
                String role = resultSet.getString(5);
                int confirm = resultSet.getInt(6);

                return new Account(idAccount, user, email, pass, role, confirm);
            }
        } catch (Exception e) {
            System.out.println("Login: " + e.getMessage());
        }

        return null;
    }

    public boolean changePassword(String username, String newPassword) {
        String query = "UPDATE account SET password = ? WHERE username = ? ";

        try ( PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;
        } catch (Exception e) {
            System.out.println("Change Password: " + e.getMessage());
        }

        return false;
    }

    public Account getAccountByUsername(String username) {
        try {
            String strSelect = "SELECT * FROM dbo.account WHERE username = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, username);
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

    public boolean addAccount(String user, String pass, String role, String email) {
        try {
            String sql = "  INSERT INTO dbo.account (username, password, role, email) VALUES (?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.setString(3, role);
            stm.setString(4, email);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean confirmAccount(String user) {
        try {
            String sql = "UPDATE dbo.account SET confirm=1\n"
                    + "WHERE username=?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean updatePassword(int id, String password) {
        try {
            String strUPDATE = "UPDATE dbo.account\n"
                    + "SET password = ?\n"
                    + "WHERE idAccount = ?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, password);
            stm.setInt(2, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public boolean addMentor(int id, String fullname, String phone, String dob, String sex, String address, String registerDate) {
        try {
            String sql = "INSERT INTO dbo.mentor\n"
                    + "(\n"
                    + "    idMentor,\n"
                    + "    fullname,\n"
                    + "    phone,\n"
                    + "    dob,\n"
                    + "    sex,\n"
                    + "    address,\n"
                    + "registerDate\n"
                    + ")\n"
                    + "VALUES (?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, fullname);
            stm.setString(3, phone);
            stm.setString(4, dob);
            stm.setString(5, sex);
            stm.setString(6, address);
            stm.setString(7, registerDate);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean addMentee(int id, String fullname, String dob, String phone, String sex, String registerDate, String address) {
        try {
            String sql = "INSERT INTO dbo.mentee\n"
                    + "(\n"
                    + "    idMentee,\n"
                    + "    fullname,\n"
                    + "    dob,\n"
                    + "    phone,\n"
                    + "    sex,\n"
                    + "    registerDate,\n"
                    + "    address\n"
                    + ")\n"
                    + "VALUES (?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, fullname);
            stm.setString(3, dob);
            stm.setString(4, phone);
            stm.setString(5, sex);
            stm.setString(6, registerDate);
            stm.setString(7, address);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public List<Request> getAllRequesttbyID(int idMentor) {
        List<Request> list = new ArrayList<>();  // Initialize a new list

        String sql = "select * from request\n"
                + "         where idMentor = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                Request objE = new Request(
                        rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getFloat(10)
                );
                if (!objE.getStatus().equals("Cancel") && !objE.getStatus().equals("Close") && !objE.getStatus().equals("Processing")) {
                    list.add(objE);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting");
            // Handle the exception properly, logging or rethrowing if needed
        }
        return list;
    }

    public boolean updateRe(int id, String newStatus) {
        try {
            String strUPDATE = "UPDATE request SET status = ? WHERE idRequest = ?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, newStatus);
            stm.setInt(2, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, log or throw a custom exception
            return false;
        }
    }
    List<Mentor> listm = new ArrayList<>();

    public List<Mentor> getAllMentor() {
        String sql = "SELECT idMentor, fullname FROM mentor";
        try ( PreparedStatement stm = connection.prepareStatement(sql);  ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Mentor mentorr = new Mentor(
                        rs.getInt("idMentor"),
                        rs.getString("fullname")
                );
                listm.add(mentorr);
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting mentors: " + e.getMessage());
            e.printStackTrace();
        }
        return listm;
    }

    public boolean insertr(Rate r) {
        try {
            String sql = "INSERT INTO [dbo].[rate]\n"
                    + "           ([idMentee]\n"
                    + "           ,[idMentor]\n"
                    + "           ,[star]\n"
                    + "           ,[comment]\n"
                    + "           ,[time])"
                    + "VALUES (?, ?, ?, ?, ?)";
            stm = connection.prepareStatement(sql);

            stm.setInt(1, r.getIdMentee());
            stm.setInt(2, r.getIdMentor());
            stm.setInt(3, r.getStar());
            stm.setString(4, r.getComment());
            stm.setString(5, r.getTime());

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public List<Skill> ListAllSkill() {
        Connection conn = null;
        String query = "SELECT * FROM skill";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                listAllSkill.add(new Skill(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listAllSkill;

    }

    public String getUserNameById(int id) {
        String user = null;
        try {
            String sql = "SELECT username FROM dbo.account \n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                user = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("loi lay user bang id");
        }
        return user;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();

        System.out.println(dao.getAllRequesttbyID(1));
    }
}
