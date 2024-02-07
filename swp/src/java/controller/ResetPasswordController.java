/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import model.Account;

@WebServlet(name = "ResetPasswordController", urlPatterns = {"/reset-password"})
public class ResetPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Account/resetpassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountname = request.getParameter("accountname");
        String emailaddress = request.getParameter("emailaddress");

        try {

            // check in db
            Account account = new DAO().getAccountByUsername(accountname);
            if (account == null) {
                request.setAttribute("message", "Account not found");
                throw new Exception();
            }

            // generate password
            String newPassword = generatePassword(8);

            // send mail
            request.setAttribute("response", sendEmail(emailaddress, "Reset password", "Your new password: " + newPassword));

            // update db
            new DAO().updatePassword(account.getId(), newPassword);

            request.setAttribute("message", "An email was sent!");
            request.getRequestDispatcher("Account/resetpassword.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("Account/resetpassword.jsp").forward(request, response);

        }

    }

    public boolean sendEmail(String to, String subject, String text) {
        // URL to which the request will be sent
        String url = "https://mail-sender-service.vercel.app/send-email";

        try {
            // Create a URL object
            URL apiUrl = new URL(url);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Set the request method
            connection.setRequestMethod("POST");

            // Enable input/output streams
            connection.setDoOutput(true);

            // Set the content type
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            // Prepare the request payload
            String payload = "{\"to\":\"" + to + "\",\"subject\":\"" + subject + "\",\"text\":\"" + text + "\"}";

            // Write the payload to the output stream
            try ( OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Close the connection
            connection.disconnect();

            return responseCode == 200;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String generatePassword(int length) {
        // Define characters to use in the password (lowercase letters and digits)
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        // Use SecureRandom for better randomness
        SecureRandom random = new SecureRandom();

        // Build the password by randomly selecting characters from the defined set
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }

}
