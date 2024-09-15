package Lesson47_unit_test_part3.classwork.task1;

import java.util.HashMap;
import java.util.Map;

public class DrinkVendingMachine {
    private final Map<String, Integer> inventory = new HashMap<>();
    private int balance = 0;

    private static final int DRINK_PRICE = 200;

    public DrinkVendingMachine() {
        inventory.put("Кола", 10);
        inventory.put("Спрайт", 8);
        inventory.put("Фанта", 5);
    }

    public void insertCoin(int value) {
        if (value > 0) {
            balance += value;
        } else {
            throw new IllegalArgumentException("Число должно быть положительным");
        }
    }

    public String selectDrink(String drinkName) {
        if (!inventory.containsKey(drinkName)) {
            return "Такого напитка нет в автомате.";
        }

        int quantity = inventory.get(drinkName);
        if (quantity == 0) {
            return "Извините, " + drinkName + " закончился.";
        }

        if (balance >= DRINK_PRICE) {
            inventory.put(drinkName, quantity - 1);
            balance -= DRINK_PRICE;
            return "Вы получили " + drinkName + "!";
        } else {
            return "Недостаточно средств.";
        }
    }

    public int getDrinkQuantity(String drinkName) {
        return inventory.getOrDefault(drinkName, 0);
    }

    public int getBalance() {
        return balance;
    }
}
