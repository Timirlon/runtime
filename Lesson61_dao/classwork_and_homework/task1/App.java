package Lesson61_dao.classwork_and_homework.task1;

import Lesson61_dao.classwork_and_homework.task1.service.CategoryService;
import Lesson61_dao.classwork_and_homework.task1.service.ProductService;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService(scanner);
        ProductService productService = new ProductService(scanner);

        while (true) {
            switch (menu()) {
                case 1 -> categoryService.findAll();
                case 2 -> categoryService.findById();
                case 3 -> productService.findAll();
                case 4 -> productService.findById();
                case 5 -> categoryService.createCategory();
                case 6 -> productService.createProduct();
                case 7 -> productService.updateProduct();
                case 8 -> productService.deleteProduct();
                case 0 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Некорректная команда.");
            }
        }
    }

    static int menu() {
        System.out.print("""
                Выберите действие:
                1 - Получить список категорий
                2 - Получить категорию по идентификатору
                3 - Получить список товаров.
                4 - Получить товар по идентификатору.
                5 - Создать категорию
                6 - Создать товар
                7 - Обновить товар
                8 - Удалить товар
                0 - Выход
                """);
        return Integer.parseInt(scanner.nextLine());
    }
}

