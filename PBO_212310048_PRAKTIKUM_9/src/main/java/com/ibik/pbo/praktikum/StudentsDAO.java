package com.ibik.pbo.praktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {

    private String queryInsert = "insert into students (npm, fullname, score) "
            + " values (?, ?, ?) ";

    private String querySelectAll = "select * from students";

    public void saved(Students students) throws Exception {
        Connection c = new DBConnection().connect();

        PreparedStatement psInsert = c.prepareStatement(queryInsert);

        psInsert.setString(1, students.getNpm());
        psInsert.setString(2, students.getFullname());
        psInsert.setString(3, students.getScore());

        psInsert.executeUpdate();

        c.close();
    }

    public List<Students> findAll() throws Exception {
        List<Students> hasil = new ArrayList<Students>();

        Connection c = new DBConnection().connect();
        PreparedStatement psFindAll = c.prepareStatement(querySelectAll);

        ResultSet rs = psFindAll.executeQuery();

        while (rs.next()) {
            Students students = konversiResultSet(rs);
            hasil.add(students);
        }

        c.close();

        return hasil;
    }

    private Students konversiResultSet(ResultSet rs) throws SQLException {
        Students students = new Students();
        students.setId(rs.getInt("id"));
        students.setNpm(rs.getString("npm"));
        students.setFullname(rs.getString("fullname"));
        students.setScore(rs.getString("score"));
        return students;
    }

}