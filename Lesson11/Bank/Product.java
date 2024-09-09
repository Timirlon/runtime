package Lesson11.Bank;


public class Product {
    String name;
    double price;

    void compareTo(Product product) {
        if(price > product.price) {
            System.out.println("Товар " + name + " дороже чем " + product.name);
        } else if (price < product.price) {
            System.out.println("Товар " + name + " дешевле чем " + product.name);
        } else {
            System.out.println("Товар " + name + " и товар " + product.name + "стоят одинаково.");
        }
    }
}
