package com.ibik.pbo.praktikum.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibik.pbo.praktikum.DBConnection;

public class RegisterDAO {

    private String queryRegister = "insert into admin (email, password, fullname, phone, gender, citizenship) "
            + "values (?, ?, ?, ?, ?, ?)";

    public void savedRegister(Admin admin) throws Exception {
        Connection c = new DBConnection().connect();

        PreparedStatement psInsert = c.prepareStatement(queryRegister);

        psInsert.setString(1, admin.getEmail());
        psInsert.setString(2, admin.getPassword());
        psInsert.setString(3, admin.getFullname());
        psInsert.setString(4, admin.getPhone());
        psInsert.setString(5, admin.getGender());
        psInsert.setString(6, admin.getCitizenship());

        psInsert.executeUpdate();

        c.close();
    }
}