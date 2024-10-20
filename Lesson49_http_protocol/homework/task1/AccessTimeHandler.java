package Lesson49_http_protocol.homework.task1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccessTimeHandler implements HttpHandler {
    private final Path path = Path.of("Lesson49_http_protocol\\homework\\task1\\Access-time-storage.txt");
    private final List<LocalDateTime> accessTimeList = new ArrayList<>();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

    public void handle(HttpExchange exchange) throws IOException {
        LocalDateTime accessTime = LocalDateTime.now();
        accessTimeList.add(accessTime);

        StringBuilder stringBuilder = new StringBuilder();

        for (LocalDateTime someAccessTime : accessTimeList) {
            stringBuilder.append(convertAccessTimeToString(someAccessTime));
            stringBuilder.append("\n");
        }

        String response = stringBuilder.toString();

        exchange.sendResponseHeaders(200, 0);

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void saveAccessTime() throws IOException {
        Writer writer = new FileWriter(path.toString());

        for (LocalDateTime accessTime : accessTimeList) {
            writer.write(accessTime.toString());
            writer.write("\n");
        }

        writer.close();
    }

    private void loadAccessTime() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path.toString()));

        while (reader.ready()) {
            String storageContent = reader.readLine();

            accessTimeList.add(LocalDateTime.parse(storageContent));
        }

        reader.close();
    }

    private String convertAccessTimeToString(LocalDateTime accessTime) {
        Period period = Period.between(accessTime.toLocalDate(), LocalDate.now());
        Duration duration = Duration.between(accessTime, LocalDateTime.now());

        String returnValue;

        if (period.getYears() > 0) {
            returnValue = period.getYears() + " year(s) ago";
        } else if (period.getMonths() > 0) {
            returnValue = period.getYears() + " month(s) ago";
        } else if (period.getDays() > 0) {
            returnValue = period.getDays() + " d ago";
        } else if (duration.toHours() > 0) {
            returnValue = duration.toHours() + " hr ago";
        } else if (duration.toMinutes() > 0) {
            returnValue = duration.toMinutes() + " min ago";
        } else {
            returnValue = duration.getSeconds() + " sec ago";
        }

        return accessTime.format(timeFormatter) + " (" + (returnValue) + ")";
    }
}
