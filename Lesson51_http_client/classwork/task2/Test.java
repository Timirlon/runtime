package Lesson51_http_client.classwork.task2;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название города: ");
        String city = scanner.nextLine();

        URI uri = URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&lang=ru&appid=79d1ca96933b0328e1c7e3e7a26cb347");

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JsonElement jsonElement = JsonParser.parseString(response.body());
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            System.out.println(jsonObject);
        } else if (response.statusCode() == 404){
            System.out.println("Введен некорректный город.");
        }



    }
}
