package Lesson49_http_protocol.classwork.task2;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CalculateSumHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().getQuery();

        String[] params = query.split("&");
        Integer firstNum = Integer.parseInt(params[0].split("=")[1]);
        Integer secondNum = Integer.parseInt(params[1].split("=")[1]);

        httpExchange.sendResponseHeaders(200, 0);

        String response = String.valueOf((firstNum + secondNum));


        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
