package Lesson60_orm.classwork_and_homework.task1;

import java.sql.*;
import java.util.*;

public class Main {
    static Map<Long, Category> categoryMap = new HashMap<>();

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/homework";
        String username = "postgres";
        String password = "1234";


        Connection connection = DriverManager.getConnection(url, username, password);

        writeAllCategoriesInMap(connection);
        System.out.println(findAllProducts(connection));

        createProduct(connection, new Product(5, "Degenatron-3000", 999.99, categoryMap.get(1L)));
        System.out.println(findAllProducts(connection));
    }

    public static List<Product> findAllProducts(Connection connection) throws SQLException {
        List<Product> products = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM products");

        try (statement; result) {
            while (result.next()) {
                Product product = new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("price"),
                        categoryMap.get(result.getLong("category_id"))
                );

                products.add(product);
            }
        }

        return products;
    }

    public static void writeAllCategoriesInMap(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM categories");

        try (statement; result) {
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");

                Category category = new Category(id, name);

                categoryMap.put(id, category);
            }
        }

    }

    // Homework
    public static void createProduct(Connection connection, Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?);");

        statement.setLong(1, product.getId());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.setLong(4, product.getCategory().getId());


        statement.execute();
    }
}
