package Lesson52_http.classwork.task1;

import com.google.gson.JsonArray;
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
        URI uri = URI.create("https://swapi.dev/api/people?format=json");

        HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

        JsonArray characters = jsonObject.getAsJsonArray("results");

        String maxHeightName = null;
        int maxHeight = 0;

        for (JsonElement jsonElement : characters) {
            JsonObject character = jsonElement.getAsJsonObject();

            int height = Integer.parseInt(character.get("height").getAsString());
            String name = character.get("name").getAsString();

            if (height > maxHeight) {
                maxHeight = height;
                maxHeightName = name;
            }

            System.out.println(name);
        }

        System.out.println();
        System.out.println("The tallest character: " + maxHeightName + " - " + maxHeight + " cm");
    }
}
