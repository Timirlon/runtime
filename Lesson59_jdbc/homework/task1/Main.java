package Lesson59_jdbc.homework.task1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/homework";
        String username = "postgres";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement getCategoriesStatement = connection.createStatement();
        ResultSet categoriesSet = getCategoriesStatement.executeQuery("SELECT * FROM categories");

        while (categoriesSet.next()) {
            System.out.println(categoriesSet.getInt("id") + ". " + categoriesSet.getString("name"));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите категорию: ");
        int category = scanner.nextInt();

        PreparedStatement getProductsStatement = connection.prepareStatement("SELECT * FROM products WHERE category_id = ?");
        getProductsStatement.setInt(1, category);

        ResultSet productSet = getProductsStatement.executeQuery();

        while (productSet.next()) {
            String name = productSet.getString("name");
            double price = productSet.getInt("price");

            System.out.println("- " + name + " (" + price + ")");
        }
    }
}
