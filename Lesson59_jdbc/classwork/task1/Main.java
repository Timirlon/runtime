package Lesson59_jdbc.classwork.task1;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/homework";
        String username = "postgres";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

        double maxPrice = 0;
        String maxPriceProd = "";

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");

            if (price > maxPrice || maxPrice == 0) {
                maxPrice = price;
                maxPriceProd = name;
            }

            System.out.println("Название: " + name);
            System.out.println("Стоимость: " + price);
        }

        System.out.println("Самый дорогой товар: " + maxPriceProd + " (" + maxPrice + ")");
    }
}
