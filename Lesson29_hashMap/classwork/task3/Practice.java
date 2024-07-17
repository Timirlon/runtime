package Lesson29_hashMap.classwork.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
    // Пример списка пассажиров (на самом деле их больше)
    private static final List<String> passengerNames = List.of(
            "Аймурат Бериков",
            "Диана Азатова",
            "Азамат Бексултанов",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    public static void main(String[] args) {
        Map<String, Integer> seats = assignSeats(passengerNames);
        System.out.println("Места пассажиров: " + seats);
    }

    public static Map<String, Integer> assignSeats(List<String> passengerNames) {
        Map<String, Integer> passengers = new HashMap<>();
        int count = 1;
        for (String passenger : passengerNames) {
            passengers.put(passenger, count);
            count++;
        }
        return passengers;
    }
}
