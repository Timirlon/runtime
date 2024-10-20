package Lesson50_http_protocol.classwork.task1;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class Practice {
    static List<Product> products = List.of(
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
    );

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/products", Practice::handleProducts);

        server.start();
    }

    //   /products?from=500&to=1000  - все товары от 500 до 1000
    static void handleProducts(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        String[] params = query.split("&");
        int minPrice = Integer.parseInt(params[0].split("=")[1]);
        int maxPrice = Integer.parseInt(params[1].split("=")[1]);


        List<Product> newProducts = products.stream()
                .filter(product -> product.price > minPrice && product.price < maxPrice)
                .toList();

        Gson gson = new Gson();
        String json = gson.toJson(newProducts);

        exchange.sendResponseHeaders(200, 0);

        OutputStream os = exchange.getResponseBody();
        os.write(json.getBytes());
        os.close();
    }

    record Product(String name, int price, ProductType type) {
    }

    enum ProductType {FRUIT, VEGETABLE, MEAT, DAIRY}
}

