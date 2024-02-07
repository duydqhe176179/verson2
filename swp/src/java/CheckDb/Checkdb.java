/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CheckDb;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author Admin
 */
public class Checkdb extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Account> listAccount = new ArrayList<>();

    public boolean IsUserExist(String user) {
        List<Account> a = getAllAccount();
        for (Account account : a) {
            if (account.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmailUsed(String email) {
        List<Account> a = getAllAccount();
        for (Account account : a) {
            if (email.equals(account.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public List<Account> getAllAccount() {
        try {
            String strSelect = "SELECT * FROM dbo.account";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idAccount = rs.getInt(1);
                String user = rs.getString(2);
                String email = rs.getString(3);
                String pass = rs.getString(4);
                String role = rs.getString(5);
                int confirm = rs.getInt(6);

                Account a = new Account(idAccount, user, email, pass, role, confirm);
                listAccount.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listAccount;
    }

    public static void main(String[] args) {
        Checkdb check = new Checkdb();
        System.out.println(check.isEmailUsed("d@gmail.com"));
    }
}
