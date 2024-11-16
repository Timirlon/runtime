package Lesson61_dao.classwork_and_homework.task1.service;

import Lesson61_dao.classwork_and_homework.task1.dao.CategoryDao;
import Lesson61_dao.classwork_and_homework.task1.model.Category;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {
    private final CategoryDao categoryDao;
    private final Scanner scanner;

    public CategoryService(Scanner scanner) {
        this.scanner = scanner;
        this.categoryDao = new CategoryDao();
    }

    public void findAll() {
        categoryDao.findAll().forEach(System.out::println);
    }

    public void findById() {
        System.out.print("Введите идентификатор категории: ");
        long id = Long.parseLong(scanner.nextLine());

        Category category = categoryDao.findById(id);
        if (category == null) {
            System.out.println("Категория не найдена");
        } else {
            System.out.println(category);
        }
    }

    public void createCategory() {
        System.out.print("Введите идентификатор новой категории: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.print("Введите название новой категории: ");
        String name = scanner.nextLine();

        try {
            categoryDao.createCategory(new Category(id, name));
        } catch (SQLException e) {
            System.out.println("Не удалось создать категорию.");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Категория успешно создана.");
    }
}

