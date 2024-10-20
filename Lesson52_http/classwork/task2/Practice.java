package Lesson52_http.classwork.task2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class Practice {
    public static void main(String[] args) throws IOException, InterruptedException {
        URI uri = URI.create("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=418969814078357800fcf2d3df514a26&with_original_language=en&language=ru");

        HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

        JsonArray characters = jsonObject.getAsJsonArray("results");

        Random random = new Random();
        int randomIndex = random.nextInt(0, characters.size());

        String randomMovieTitle = characters.get(randomIndex).getAsJsonObject().get("title").getAsString();

        System.out.println("Название случайного фильма: " + randomMovieTitle);
    }
}
