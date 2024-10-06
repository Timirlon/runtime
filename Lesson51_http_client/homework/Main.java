package Lesson51_http_client.homework;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {
    private static final List<String> currencies = new ArrayList<>(List.of("USD", "EUR", "RUB"));
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runProgram = true;

        while (runProgram) {
            printMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCurrency();
                    break;
                case 2:
                    convert();
                    break;
                case 0:
                    runProgram = false;
            }
        }
    }

    private static void printMenu() {
        System.out.println("1 - Добавить валюту");
        System.out.println("2 - Конвертировать");
        System.out.println("0 - Выйти");
    }

    private static void addCurrency() {
        System.out.print("Введите новую существующую валюту: ");
        String newCurrency = scanner.next();

        if (currencies.contains(newCurrency)) {
            System.out.println("Валюта уже добавлена.");
            return;
        }

        HttpResponse<String> response = getResponseFromCurrencySite(newCurrency);

        if (response.statusCode() == 200) {
            currencies.add(newCurrency);
        } else {
            System.out.println("Валюта не найдена.");
        }
    }

    private static void convert() {
        System.out.print("Сумма в тенге: ");
        int amountInTg = scanner.nextInt();

        currencies.forEach(cur -> System.out.println("- " + cur));

        System.out.print("Выберите валюту: ");
        String selectedCur = scanner.next();

        HttpResponse<String> response = getResponseFromCurrencySite(selectedCur);

        if (response.statusCode() == 200 && currencies.contains(selectedCur)) {
            JsonElement jsonElement = JsonParser.parseString(response.body());
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            double exchangeRate = jsonObject.get("rates").getAsJsonObject().get("KZT").getAsDouble();

            System.out.println(amountInTg + " тг в " + selectedCur + " составляет: " + (amountInTg / exchangeRate));
        } else {
            System.out.println("Валюта не найдена.");
        }
    }

    private static HttpResponse<String> getResponseFromCurrencySite(String selectedCurrency) {
        URI uri = URI.create("https://api.apilayer.com/exchangerates_data/latest?base=" + selectedCurrency + "&symbols=KZT&apikey=iISN69jOgAmSSuWq5GG68tko23CuqMLk");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException ie) {
            System.out.println(ie.getMessage());
        }

        return response;
    }
}
