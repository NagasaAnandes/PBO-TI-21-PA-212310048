package com.ibik.pbo.praktikum;

import javax.swing.JOptionPane;
import com.ibik.pbo.praktikum.Auth.*;

public class App {
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        try {
            db.connect();
            // RegisterForm regForm = new RegisterForm();
            LoginForm login = new LoginForm();
            login.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}