package Lesson49_http_protocol.classwork.task1;

import Lesson49_http_protocol.classwork.task2.CalculateSumHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Practice {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();

        httpServer.bind(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler());

        httpServer.createContext("/day-of-the-week", new RandomWeekDayHandler());

        httpServer.createContext("/calculate", new CalculateSumHandler());

        httpServer.start(); // запускаем сервер

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }
}
