package ru.renicheronte.springMVC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/my_db";
    private static final String DB_USERNAME = "bestuser";
    private static final String DB_PASSWORD = "bestuser";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            return connection;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
