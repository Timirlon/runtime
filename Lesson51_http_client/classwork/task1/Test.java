package Lesson51_http_client.classwork.task1;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        URI uri = URI.create("https://api.openweathermap.org/data/2.5/weather?q=Astana&units=metric&lang=ru&appid=79d1ca96933b0328e1c7e3e7a26cb347");

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());


        JsonElement jsonElement = JsonParser.parseString(response.body());
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        long temperature = Math.round(jsonObject.get("main").getAsJsonObject().get("temp").getAsDouble());

        System.out.println(temperature);
        System.out.println(jsonObject.get("wind").getAsJsonObject().get("speed"));
    }
}
