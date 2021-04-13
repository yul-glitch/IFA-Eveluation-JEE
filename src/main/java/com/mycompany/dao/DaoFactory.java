package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory
{
    private String url;
    private String username;
    private String password;

    public DaoFactory(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        String USER = "root";
        String PASSWORD = "psIMzL+Dpwn76MqozByt";
        String connString = "jdbc:mysql://localhost:3306/TENNIS?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris&characterEncoding=UTF-8";

        return new DaoFactory(connString, USER, PASSWORD);
    }

    public Connection getConnection() throws SQLException
    {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

}
