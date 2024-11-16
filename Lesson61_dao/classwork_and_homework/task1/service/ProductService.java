package Lesson61_dao.classwork_and_homework.task1.service;

import Lesson61_dao.classwork_and_homework.task1.dao.ProductDao;
import Lesson61_dao.classwork_and_homework.task1.model.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {
    private final ProductDao productDao;
    private final Scanner scanner;

    public ProductService(Scanner scanner) {
        this.scanner = scanner;
        productDao = new ProductDao();
    }

    public void findAll() {
        productDao.findAll().forEach(System.out::println);
    }

    public void findById() {
        System.out.print("Введите идентификатор продукта: ");
        long id = Long.parseLong(scanner.nextLine());

        Product product = productDao.findById(id);
        if (product == null) {
            System.out.println("Продукт не найден.");
        } else {
            System.out.println(product);
        }
    }

    public void createProduct() {
        System.out.print("Введите идентификатор нового продукта: ");
        long id = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите название нового продукта: ");
        String name = scanner.nextLine();
        System.out.print("Введите стоимость нового продукта: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите идентификатор категории нового продукта: ");
        long categoryId = Long.parseLong(scanner.nextLine());

        try {
            productDao.createProduct(id, name, price, categoryId);
        } catch (SQLException e) {
            System.out.println("Не удалось создать продукт.");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Продукт успешно создан.");
    }

    public void updateProduct() {
        System.out.print("Введите идентификатор продукта, которые вы хотите обновить: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.print("Введите новое имя продукта: ");
        String newName = scanner.nextLine();
        System.out.print("Введите новую цену продукта: ");
        double newPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите новый идентификатор категории продукта: ");
        long newCategoryId = Long.parseLong(scanner.nextLine());

        try {
            productDao.updateProduct(id, newName, newPrice, newCategoryId);
        } catch (SQLException e) {
            System.out.println("Не удалось обновить продукт.");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Продукт успешно обновлен.");
    }

    public void deleteProduct() {
        System.out.print("Введите идентификатор продукта, который хотите удалить: ");
        long id = Long.parseLong(scanner.nextLine());

        try {
            productDao.deleteProduct(id);
        } catch (SQLException e) {
            System.out.println("Не удалось удалить продукт.");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Продукт успешно удален.");
    }
}
