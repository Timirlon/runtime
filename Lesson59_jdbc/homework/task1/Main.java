package Lesson59_jdbc.homework.task1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/homework";
        String username = "postgres";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Процессоры");
        System.out.println("2. Мониторы");
        System.out.print("Выберите категорию: ");
        int category = scanner.nextInt();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE category_id = ?");
        statement.setInt(1, category);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getInt("price");

            System.out.println("- " + name + " (" + price + ")");
        }
    }
}
