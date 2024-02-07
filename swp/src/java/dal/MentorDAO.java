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
import java.util.Date;
import java.util.List;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.Request;
import model.Skill;
import model.SkillMentor;
import model.info;

/**
 *
 * @author admin
 */
public class MentorDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Mentor> listMentor = new ArrayList<>();
    List<Have_SKill> listhskill = new ArrayList<>();
    List<info> listinfo = new ArrayList<>();
    List<SkillMentor> skill = new ArrayList<>();

    public boolean deleteMentorbyhaveskill(int idMentor) {
        try {
            String sql = "DELETE FROM [dbo].[have_skill]\n"
                    + "      WHERE idMentor=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            // Close the connection here if necessary
        }
    }

    public List<SkillMentor> getAllskill() {
        try {

            String strSelect = "select * \n"
                    + "from skill";

            stm = connection.prepareStatement(strSelect);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tiltle = rs.getString(2);
                String image = rs.getString(3);
                String skillName = rs.getString(4);
                String Skill_description = rs.getString(5);
                String status = rs.getString(6);
                SkillMentor a = new SkillMentor(id, tiltle, image, skillName, Skill_description, status);
                skill.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return skill;
    }

    public boolean updateCV(int id_Mentor, String fullname, String avatar, String phone, String dob, String sex, String address, String profession, String pro_introduc,
            String archivement_descition, String framework, String experience, String education, String myservice, String[] idSkill) {
        try {

            String strUPDATE = "UPDATE [dbo].[mentor]\n"
                    + "   SET \n"
                    + "      [fullname] = ?,\n"
                    + "      [avatar] = ?,\n"
                    + "      [phone] = ?,\n"
                    + "      [dob] = ?,\n"
                    + "      [sex] = ?,\n"
                    + "      [address] = ?,\n"
                    + "      [profession] = ?,\n"
                    + "      [pro_introduc] = ?,\n"
                    + "      [archivement_descition] = ?,\n"
                    + "      [framework] = ?,\n"
                    + "      [experience] = ?,\n"
                    + "      [education] = ?,\n"
                    + "      [myservice] = ?\n"
                    + " WHERE idMentor = ?;";
            PreparedStatement stm;
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, fullname);
            stm.setString(2, avatar);
            stm.setString(3, phone);
            stm.setString(4, dob);
            stm.setString(5, sex);
            stm.setString(6, address);

            stm.setString(7, profession);
            stm.setString(8, pro_introduc);
            stm.setString(9, archivement_descition);
            stm.setString(10, framework);
            stm.setString(11, experience);
            stm.setString(12, education);
            stm.setString(13, myservice);
            stm.setInt(14, id_Mentor);
            stm.executeUpdate();

            String sql2 = " UPDATE [dbo].[have_skill]\n"
                    + "   SET \n"
                    + "      [idSkill] = ?\n"
                    + "      \n"
                    + "     \n"
                    + " WHERE idMentor=?";

            PreparedStatement stm2;
            stm2 = connection.prepareStatement(sql2);

            for (String string : idSkill) {
                int value_id = Integer.parseInt(string);
                stm2.setInt(1, value_id);
                stm2.setInt(2, id_Mentor);
                stm2.executeUpdate();

            }
            //stm2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("loi, ko update dc");
            return false;
        }
        return true;

    }

    public Mentor getIDMentor(int IdMentor) {
        try {
            String strSelect = "select * from mentor where idMentor = ?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String phone = rs.getString(4);

                String dob = rs.getString(5);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Chuyển đổi ngày sinh từ chuỗi sang LocalDate
                LocalDate ngaySinh = LocalDate.parse(dob, formatter);

                // Lấy ngày hiện tại
                LocalDate ngayHienTai = LocalDate.now();

                // Tính tuổi
                Period period = Period.between(ngaySinh, ngayHienTai);

                String sex = rs.getString(6);
                String address = rs.getString(7);
                String registerDate = rs.getString(8);
                String profession = rs.getString(9);
                String pro_introduc = rs.getString(10);
                String archivement_sescition = rs.getString(11);
                String framework = rs.getString(12);
                String experience = rs.getString(13);
                String education = rs.getString(14);
                String myservice = rs.getString(15);
                int age = period.getYears();

                Mentor a = new Mentor(idMentor, fullname, avatar, phone, dob, sex, address, registerDate, profession, pro_introduc, archivement_sescition, framework, experience, education, myservice, age);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Mentor> getListOfMentors() {
        List<Mentor> mentors = new ArrayList();
        String query = "SELECT * FROM mentor";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Mentor mentor = mapResultSetToMentor(resultSet);
                mentors.add(mentor);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving mentors" + e.getMessage());
        }

        return mentors;
    }
     private Mentor mapResultSetToMentor(ResultSet resultSet) throws Exception {
        return new Mentor(
                resultSet.getInt("idMentor"),
                resultSet.getString("fullname"),
                resultSet.getString("avatar"),
                resultSet.getString("phone"),
                resultSet.getString("dob"),
                resultSet.getString("sex"),
                resultSet.getString("address"),
                resultSet.getString("registerDate"),
                resultSet.getString("profession"),
                resultSet.getString("pro_introduc"),
                resultSet.getString("archivement_descition"),
                resultSet.getString("framework"),
                resultSet.getString("experience"),
                resultSet.getString("education"),
                resultSet.getString("myservice"),
                resultSet.getInt("stk")
        );
    }
    public SkillMentor skill() {
        try {
            String strSelect = "select * \n"
                    + "from skill";

            stm = connection.prepareStatement(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String tiltle = rs.getString(2);

                String image = rs.getString(3);
                String skillName = rs.getString(4);
                String Skill_description = rs.getString(5);
                String status = rs.getString(6);
                SkillMentor a = new SkillMentor(id, tiltle, image, skillName, Skill_description, status);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Have_SKill> getidhaveskill(int IdMentor) {
        try {
            String strSelect = "select idMentor,idSkill,skillName \n"
                    + "from have_skill join skill on have_skill.idSkill = skill.id \n"
                    + "where have_skill.idMentor=?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                int idSkill = rs.getInt(2);

                String skillname = rs.getString(3);

                Have_SKill a = new Have_SKill(idMentor, idSkill, skillname);
                listhskill.add(a);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listhskill;
    }

    public info info() {
        try {
            String strSelect = "select * from info where idMentor = 6";

            stm = connection.prepareStatement(strSelect);

            rs = stm.executeQuery();
            while (rs.next()) {
                int idInfo = rs.getInt(1);
                int idMentor = rs.getInt(2);
                String link = rs.getString(3);
                info a = new info(idInfo, idMentor, link);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public info getIdinfo(int IdMentor) {
        try {
            String strSelect = "select * from info where idMentor = ?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idInfo = rs.getInt(1);
                int idMentor = rs.getInt(2);
                String link = rs.getString(3);
                info a = new info(idInfo, idMentor, link);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
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

    public boolean addHave_Skill(Have_SKill r) {
        try {
            String strSelect = "  INSERT INTO [dbo].[have_skill] ([idMentor], [idSkill])\n"
                    + "VALUES (?, ?);\n"
                    + "                           ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, r.getIdMentor());
            stm.setInt(2, r.getIdSkill());

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public List<Mentor> listMentorBySkill(String skillName) {
        List<Mentor> mentors = new ArrayList<>();
        try {
            String sql = "SELECT mentor.idMentor,fullname,username,idSkill,skillName\n"
                    + "FROM dbo.account JOIN dbo.mentor ON mentor.idMentor = account.idAccount\n"
                    + "JOIN dbo.have_skill ON have_skill.idMentor = mentor.idMentor\n"
                    + "JOIN dbo.skill ON skill.id = have_skill.idSkill\n"
                    + "WHERE skillName like ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + skillName + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                String fullname = rs.getString(2);
                String user = rs.getString(3);
                int idSkill = rs.getInt(4);
                String nameSkill = rs.getString(5);

//                Mentor m = new Mentor(idMentor, fullname, rate, user, totalRequest, totalInvite, idSkill, nameSkill);
//                mentors.add(new Mentor(idMentor, fullname, rate, user, totalRequest, totalInvite, idSkill, nameSkill));
                mentors.add(new Mentor(idMentor, fullname, user, idSkill, nameSkill));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi ham listMentorBySkill");
        }
        return mentors;
    }

    public float getRate(int idMentor) {
        float sum = 0;
        int count = 0;
        try {
            String sql = "SELECT * FROM dbo.rate \n"
                    + "WHERE idMentor=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                sum += rs.getInt(4);
                count++;
            }
            return (float) (sum / count);
        } catch (Exception e) {
            return 0;
        }
    }

    public int totalRequest(int idMentor) {
        int totalRequest = 0;
        try {
            String sql = "SELECT COUNT(idRequest) FROM dbo.request\n"
                    + "WHERE idMentor=? ";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            if (rs.next()) {
                totalRequest = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ko lay duoc total request");
        }
        return totalRequest;
    }

    public int totalInvite(int idMentor) {
        int total = 0;
        try {
            String sql = "SELECT COUNT(idRequest) FROM dbo.request\n"
                    + "WHERE idMentor=?  AND status='Open'";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ko lay dc total invite");
        }
        return total;
    }
    
    public List<Mentor> getMentor() {
        Connection conn = null;
        List<Mentor> listMentor1 = new ArrayList<>();
        String query = "SELECT idMentor, fullname from mentor";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                listMentor1.add(new Mentor(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listMentor1;
    }

    public List<Skill> getSkill() {
        Connection conn = null;
        List<Skill> list1 = new ArrayList<>();
        String query = "SELECT * from Skill";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                list1.add(new Skill(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return list1;
    }

    public List<Request> ListRequestById(int idMentor) {
        List<Request> list5 = new ArrayList<>();
        Connection conn = null;
        String query = "SELECT idRequest, idMentee, title, content, skill, status, deadline, hour " +
                   "FROM request r JOIN account a ON r.idMentor = a.idAccount " +
                   "WHERE a.idAccount =  ? " ;
        
    PreparedStatement _stm;
    ResultSet rs;
        try {
            conn = new DBContext().connection;
            _stm = conn.prepareStatement(query);
            _stm.setInt(1, idMentor);
            rs = _stm.executeQuery();
            while (rs.next()) {
                int idRequest=rs.getInt(1);
                int idMentee =rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String skill = rs.getString(5);
                String status = rs.getString(6);
                String deadline = rs.getString(7);
                float hour = rs.getFloat(8);
                
                list5.add(new Request(idRequest, idMentee, idMentor, title, content, skill, status, deadline, hour));
            }
        } catch (Exception e) {
        }
        return list5;
    }

    public static void main(String[] args) {
        MentorDAO mentorDAO = new MentorDAO();
        List<Mentor> vd = new ArrayList<>();
        vd = mentorDAO.listMentorBySkill("C#");
        System.out.println(vd.get(0).getTotalRequest());

    }
}
