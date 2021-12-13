package com.example.tb_spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MConnectionMaker implements ConnectionMaker{

    // 관심사의 분리 ( Connection 분리 )
    public Connection makeConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "admin");
        return c;
    }
}
