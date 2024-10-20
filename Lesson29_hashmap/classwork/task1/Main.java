package Lesson29_hashMap.classwork.task1;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // хеш-таблица содержит информацию о количестве жителей в разных городах
        Map<String, Integer> citiesPopulation = new HashMap<>();
        citiesPopulation.put("Москва", 12_655_050);
        citiesPopulation.put("Лондон", 8_961_989);
        citiesPopulation.put("Нью-Йорк", 8_804_190);

        // попытаемся узнать, каким будет население Парижа через год
        String city = "Париж";

        if (citiesPopulation.containsKey(city)) {
            Integer cityPopulation = citiesPopulation.get(city);
            System.out.println("Через 1 год население города " + city + " будет: " + (int)(cityPopulation * 1.01));
        } else {
            System.out.println("Информация о городе " + city + " отсутствует.");
        }
    }
}
