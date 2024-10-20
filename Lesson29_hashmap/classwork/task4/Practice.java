package Lesson29_hashMap.classwork.task4;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    private Map<String, Integer> orders = new HashMap<>();
    int count = 0;

    public static void main(String[] args) {
        Practice pizzeria = new Practice();
        pizzeria.openPizzeria();
        pizzeria.printStatistics();
    }

    private void openPizzeria() {
        newOrder("Леонардо");
        newOrder("Донателло");
        newOrder("Рафаэль");
        newOrder("Леонардо");
        newOrder("Микеланджело");
        newOrder("Шреддер");
        newOrder("Донателло");
    }

    private void newOrder(String clientName) {
        if (orders.containsKey(clientName)) {
            orders.put(clientName, orders.get(clientName) + 1);
        } else {
            orders.put(clientName, 1);
        }
        count++;
    }

    private void printStatistics() {
        System.out.println(orders);
        System.out.println("Всего заказов: " + count);
    }
}
