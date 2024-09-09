package Lesson14.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Category food = new Category("Groceries");
        food.products = new Product[5];

        Product cola = new Product("Coke", 450);

        Product pringles = new Product("Pringles", 2000);

        food.addProduct(cola);
        food.addProduct(pringles);

        System.out.println("Товары в категории: " + Arrays.toString(food.products));
        System.out.println("Самый дорогой товар в категории: " + food.getThePriciestProduct());
        System.out.println("Средняя цена товаров в категории: " + food.getAveragePriceOfProducts());

    }
}

class Product {
    String name;
    double price;

    public Product(String newName, double newPrice) {
        name = newName;
        price = newPrice;
    }
}

class Category {
    String name;
    Product[] products;

    public Category(String newName) {
        name = newName;
    }
    void addProduct (Product newProduct) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = newProduct;
                return;
            }
        }
        System.out.println("Недостаточно места для добавления продукта.");
    }

    double getThePriciestProduct () {
        Product max = products[0];

        for(Product product : products) {
            if (product != null && product.price > max.price) {
                max = product;
            }
        }
        return max.price;
    }

    double getAveragePriceOfProducts () {
        double averagePrice = 0;
        int countNonNull = 0;
        for (Product product  : products) {
            if (product != null) {
                averagePrice += product.price;
                countNonNull++;
            }
        }
        averagePrice /= countNonNull;
        return averagePrice;
    }
}
