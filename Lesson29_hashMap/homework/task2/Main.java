package Lesson29_hashMap.homework.task2;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        double imdbMax = 0;
        String imdbMaxString = "null";

        double kinopoiskMax = 0;
        String kinopoiskMaxString = "null";

        Map<String, Map<String, Double>> films = new HashMap<>();
        Map<String, Double> value = new HashMap<>(){{
            put("IMDb", 8.6);
            put("Kinopoisk", 8.7);
        }};
        films.put("Interstellar", value);

        value = new HashMap<>(){{
            put("IMDb", 8.8);
            put("Kinopoisk", 8.6);
        }};
        films.put("Inception", value);

        value = new HashMap<>(){{
            put("IMDb", 8.3);
            put("Kinopoisk", 8.2);
        }};
        films.put("Star Wars IV: Return of the Jedi", value);

        for (Map.Entry<String, Map<String, Double>> filmEntry : films.entrySet()) {
            System.out.println("Фильм: " + filmEntry.getKey());
            System.out.println("Оценки:");
            for (Map.Entry<String, Double> ratingEntry : filmEntry.getValue().entrySet()) {
                String ratingKey = ratingEntry.getKey();
                Double ratingValue = ratingEntry.getValue();

                System.out.println(ratingKey + ": " + ratingValue);

                if(ratingKey.equals("IMDb") && ratingValue > imdbMax) {
                    imdbMax = ratingValue;
                    imdbMaxString = filmEntry.getKey();
                } else if (ratingKey.equals("Kinopoisk") && ratingValue > kinopoiskMax) {
                    kinopoiskMax = ratingValue;
                    kinopoiskMaxString = filmEntry.getKey();
                }
            }
            System.out.println();
        }

        System.out.println("Самый высоко оцененный фильм в IMDb: " + imdbMaxString + "(" + imdbMax + ")");
        System.out.println("Самый высоко оцененный фильм в Kinopoisk: " + kinopoiskMaxString + "(" + kinopoiskMax + ")");
    }
}
