package Lesson50_http_protocol.classwork.task2;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Practice {
    static List<Product> products = new ArrayList<>(List.of(
            new Product("Apple", 450, ProductType.FRUIT),
            new Product("Banana", 700, ProductType.FRUIT),
            new Product("Carrot", 300, ProductType.VEGETABLE),
            new Product("Tomato", 600, ProductType.VEGETABLE),
            new Product("Orange", 800, ProductType.FRUIT),
            new Product("Cucumber", 400, ProductType.VEGETABLE),
            new Product("Grapes", 1200, ProductType.FRUIT),
            new Product("Potato", 200, ProductType.VEGETABLE),
            new Product("Beef", 4500, ProductType.MEAT),
            new Product("Chicken", 2000, ProductType.MEAT),
            new Product("Pork", 3000, ProductType.MEAT),
            new Product("Milk", 500, ProductType.DAIRY),
            new Product("Cheese", 1500, ProductType.DAIRY),
            new Product("Yogurt", 800, ProductType.DAIRY)
    ));

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/products", Practice::handleProducts);

        server.start();
    }

    static void handleProducts(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();

        exchange.sendResponseHeaders(200, 0);

        Gson gson = new Gson();

        String method = exchange.getRequestMethod();
        String response = null;
        switch (method) {
            case "GET":
                if (path.equals("/products")) {
                    response = gson.toJson(products);
                } else {
                    String[] splitPath = path.split("/");
                    String requestedProductName = splitPath[splitPath.length - 1];

                    for (Product product : products) {
                        if (product.name.equals(requestedProductName)) {
                            response = gson.toJson(product);
                            break;
                        }
                    }
                    if(response == null) {
                        response = "Товар не найден";
                    }

                }

                break;

            case "POST":
                System.out.println("post hit");
                InputStream inputStream = exchange.getRequestBody();
                String body = new String(inputStream.readAllBytes());
                System.out.println(body);

                Product product = gson.fromJson(body, Product.class);
                System.out.println(product);
                products.add(product);

                response = gson.toJson(product);
                break;
            default:
                response = "Некорректный http метод";
        }

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    record Product(String name, int price, ProductType type) {
    }

    enum ProductType {FRUIT, VEGETABLE, MEAT, DAIRY}
}
