package Lesson14.task1;

public class Test {
    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Product();
        products[0].name = "Coca-Cola";
        products[0].price = 400;

        products[1] = new Product();
        products[1].name = "Pringles";
        products[1].price = 1500;

        products[2] = new Product();
        products[2].name = "Snickers";
        products[2].price = 350;


        Product max = products[0];

        for(Product product : products) {
            if (product != null && product.price > max.price) {
                max = product;
            }
        }
        System.out.println(max.name + " " + max.price);
        /*
        double sum = 0;
        for(Product product: products) {
            if (product != null) {
                System.out.print(product.name + " ");
                sum += product.price;
            }
        }
        System.out.println();
        System.out.println(sum);

         */
    }
}

class Product {
    String name;
    double price;
}
