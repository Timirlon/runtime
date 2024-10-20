package Lesson29_hashMap.homework.task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> sales1 = new HashMap<>();
        sales1.put("Товар A", 10);
        sales1.put("Товар B", 5);
        sales1.put("Товар C", 8);


        HashMap<String, Integer> sales2 = new HashMap<>();
        sales2.put("Товар B", 3);
        sales2.put("Товар D", 7);
        sales2.put("Товар E", 2);

        for (Map.Entry<String, Integer> entry : sales2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (sales1.containsKey(key)) {
                sales1.put(key, sales1.get(key) + value);
            } else {
                sales1.put(key, value);
            }
        }

        System.out.println("Total sales: ");
        System.out.println(sales1);
    }
}
