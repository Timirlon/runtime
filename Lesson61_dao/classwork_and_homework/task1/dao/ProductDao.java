package Lesson61_dao.classwork_and_homework.task1.dao;

import Lesson61_dao.classwork_and_homework.task1.model.*;
import static Lesson61_dao.classwork_and_homework.task1.utils.ConnectionFactory.getConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT p.id AS product_id, p.name AS product_name, p.price, c.id AS category_id, c.name AS category_name FROM products p JOIN categories c ON p.category_id = c.id;")
        ) {
            while (result.next()) {
                Product product = makeProduct(result);
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    public Product findById(long id) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT p.id AS product_id, p.name AS product_name, p.price, c.id AS category_id, c.name AS category_name FROM products p JOIN categories c ON p.category_id = c.id WHERE p.id = ?")
                ) {
            statement.setLong(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    return makeProduct(result);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private Product makeProduct(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getLong("product_id"),
                resultSet.getString("product_name"),
                resultSet.getDouble("price"),
                new Category(resultSet.getLong("category_id"), resultSet.getString("category_name"))
                );
    }

    public void createProduct(Product product) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?);");

        statement.setLong(1, product.getId());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.setLong(4, product.getCategory().getId());


        statement.execute();
    }

    public void createProduct(long productId, String productName, double productPrice, long productCategoryId) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?);");

        statement.setLong(1, productId);
        statement.setString(2, productName);
        statement.setDouble(3, productPrice);
        statement.setLong(4, productCategoryId);


        statement.execute();
    }

    public void updateProduct(long queriedProductId, String newName, double newPrice, long newCategoryId) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE products SET name = ?, price = ?, category_id = ? WHERE id = ?");

        statement.setString(1, newName);
        statement.setDouble(2, newPrice);
        statement.setLong(3, newCategoryId);
        statement.setLong(4, queriedProductId);

        statement.execute();
    }

    public void deleteProduct(long productId) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ?");

        statement.setLong(1, productId);

        statement.execute();
    }
}
