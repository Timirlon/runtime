package Lesson49_http_protocol.homework.task1;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        final int PORT = 2000;

        HttpServer httpServer = HttpServer.create();

        httpServer.bind(new InetSocketAddress(PORT), 0);

        httpServer.createContext("/show-access-time", new AccessTimeHandler());

        httpServer.start();
    }
}
