package Lesson49_http_protocol.classwork.task1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class RandomWeekDayHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String[] daysOfTheWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        Random random = new Random();

        int randomInt = random.nextInt(daysOfTheWeek.length);

        String response = daysOfTheWeek[randomInt];
        httpExchange.sendResponseHeaders(200, 0);

        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
