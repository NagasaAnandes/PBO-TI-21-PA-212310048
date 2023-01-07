package com.ibik.pbo.praktikum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection c;

    public Connection connect() throws SQLException {
        String host = "127.0.0.1";
        String dbName = "db_pbo";
        String dbuser = "root";
        String dbpassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName, dbuser, dbpassword);

        return c;
    }

    public Connection close() throws SQLException {
        c.close();
        return c;
    }
}