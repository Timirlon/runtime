package Lesson61_dao.classwork_and_homework.task1.dao;

import Lesson61_dao.classwork_and_homework.task1.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Lesson61_dao.classwork_and_homework.task1.utils.ConnectionFactory.getConnection;

public class CategoryDao {
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from categories")
        ) {
            while (resultSet.next()) {
                Category category = makeCategory(resultSet);
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    public Category findById(long id) {
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement("select * from categories where id = ?")
        ) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return makeCategory(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Category makeCategory(ResultSet resultSet) throws SQLException {
        return new Category(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }

    public void createCategory(Category category) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO categories VALUES (?, ?);");

        statement.setLong(1, category.getId());
        statement.setString(2, category.getName());


        statement.execute();
    }
}

