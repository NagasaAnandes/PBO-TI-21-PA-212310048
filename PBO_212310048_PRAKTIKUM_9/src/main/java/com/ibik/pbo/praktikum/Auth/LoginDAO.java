package com.ibik.pbo.praktikum.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibik.pbo.praktikum.DBConnection;

public class LoginDAO {
    private String queryLogin = "select * from admin where email = ? and password = ?";

    public boolean authLogin(String email, String password) throws Exception {
        boolean isUser = false;
        try {
            Connection c = new DBConnection().connect();
            PreparedStatement ps = c.prepareStatement(queryLogin);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                isUser = true;
                System.out.println("Login Success!");
            } else {
                System.out.println("Invalid username or password!");
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return isUser;
    }
}


