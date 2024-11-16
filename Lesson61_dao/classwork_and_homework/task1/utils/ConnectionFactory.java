package Lesson61_dao.classwork_and_homework.task1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/homework";
        String user = "postgres";
        String password = "1234";

        return DriverManager.getConnection(url, user, password);
    }
}

