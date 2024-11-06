package Lesson59_jdbc.homework.task2;

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
        System.out.print("Введите id категории (через запятую и пробел): ");
        String categories = scanner.nextLine();
        String[] splitCategories = categories.split(", ");

        StringBuilder queryBuilder = new StringBuilder("?");

        for (int i = 0; i < splitCategories.length; i++) {
            if (i == 0) {
                continue;
            }

            queryBuilder.append(", ?");
        }


        PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE category_id IN (" + queryBuilder + ");");
        for (int i = 0; i < splitCategories.length; i++) {
            statement.setInt(i + 1, Integer.parseInt(splitCategories[i]));
        }

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            String name = result.getString("name");
            double price = result.getDouble("price");

            System.out.println("- " + name + " (" + price + ")");
        }
    }
}
