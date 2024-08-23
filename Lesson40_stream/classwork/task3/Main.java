package Lesson40_stream.classwork.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Яблоко", 450, ProductType.FRUIT));
        products.add(new Product("Банан", 700, ProductType.FRUIT));
        products.add(new Product("Морковь", 300, ProductType.VEGETABLE));
        products.add(new Product("Помидор", 600, ProductType.VEGETABLE));
        products.add(new Product("Апельсин", 800, ProductType.FRUIT));
        products.add(new Product("Огурец", 400, ProductType.VEGETABLE));
        products.add(new Product("Виноград", 1200, ProductType.FRUIT));
        products.add(new Product("Картофель", 200, ProductType.VEGETABLE));
        products.add(new Product("Говядина", 4500, ProductType.MEAT));
        products.add(new Product("Курица", 2000, ProductType.MEAT));
        products.add(new Product("Свинина", 3000, ProductType.MEAT));
        products.add(new Product("Молоко", 500, ProductType.DAIRY));
        products.add(new Product("Сыр", 1500, ProductType.DAIRY));
        products.add(new Product("Йогурт", 800, ProductType.DAIRY));

        // classwork
        products.stream()
                .filter(product -> product.type() == ProductType.FRUIT)
                .forEach(product -> System.out.println(product.name()));

        System.out.println(products.stream()
                .filter(product -> product.type() == ProductType.VEGETABLE)
                .count());

        products.stream()
                .filter(product -> product.price() >= 1000 && product.price() <= 2000)
                .forEach(product -> System.out.println(product.name()));

        // homework
        // task 1
        products.stream()
                .filter(product -> product.type() == ProductType.FRUIT && product.price() < 1000)
                .map(product -> new Product(product.name(), product.price() + product.price() / 5, product.type()))
                .forEach(product -> System.out.println(product.name() + " - " + product.price() + " тенге"));

        // task 2
        Comparator<Product> comparator = (product1, product2) -> product2.price() - product1.price();


        OptionalInt totalPrice = products.stream()
                .filter(product -> product.type() == ProductType.MEAT || product.type() == ProductType.DAIRY)
                .map(product -> new Product(product.name(), product.price() - product.price() / 10, product.type()))
                .filter(product -> product.price() > 2000)
                .sorted(comparator)
                .peek(product -> System.out.println(product.name() + " - " + product.price() + " тенге"))
                .mapToInt(product -> product.price())
                .reduce((product1, product2) -> product1 + product2);

        System.out.println("Общая стоимость: " + totalPrice.getAsInt() + " тенге");
    }
}

record Product(String name, int price, ProductType type) {
}

enum ProductType {
    FRUIT,
    VEGETABLE,
    MEAT,
    DAIRY
}
