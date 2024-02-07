/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmailDAO;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class Email {
    // pass : pvcr jzdx wsok htzl
    // email : swp2357@gmail.com

    public String verifyMail() {
        Random random = new Random();
        int code = random.nextInt(999999);
        return String.format("%06d", code);
    }

    public boolean sendEmail(String to,String verify) {
        final String from = "swp2357@gmail.com";
        final String password = "pvcr jzdx wsok htzl";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Phiên làm viêc
        Session session = Session.getInstance(props, auth);

        // gui email
        //tao 1 tin nhan
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            // Nguoi gui
            msg.setFrom(from);
            //Nguoi nhan
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // Tieu de email
            msg.setSubject("Please verify your account in Happy Programing" + System.currentTimeMillis());
            // Quy dinh ngay gui
            msg.setSentDate(new Date());

            //Quy dinh email nhan phan hoi
            //msg.setReplyTo(InternetAddress.parse(from,false));
            // Noi dung
            msg.setText("You have been successfully register. Please enter your code to comfirm your account. Your code is:   "+verify);

            // gui email
            Transport.send(msg);
            System.out.println("ok");
            return true;
        } catch (Exception e) {
            System.err.println("loi");
            return false;
        }
    }

    public static void main(String[] args) {
        Email email = new Email();
        System.out.println(email.sendEmail("dduy2357@gmail.com", "123456"));
    }
}
