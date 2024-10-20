package Lesson50_http_protocol.classwork.example1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Test {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        httpServer.createContext("/users", Test::handleUsers);

        httpServer.start();
    }

    public static void handleUsers(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, 0);


    }
}
