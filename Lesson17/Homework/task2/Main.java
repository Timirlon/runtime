package Lesson17.Homework.task2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в тенге: ");
        double money = scanner.nextDouble();

        HashMap<String, Double> currencies = new HashMap<>();

        currencies.put("USD", 441.58);
        currencies.put("EUR", 476.46);
        currencies.put("JPY", 2.82);

        System.out.println("Выберите валюту: ");
        for (String currency : currencies.keySet()) {
            System.out.println(currency);
        }
        System.out.println();
        String input = scanner.next();
        if (currencies.containsKey(input)) {
            double converted = money / currencies.get(input);
            System.out.println(money + "тг. в " + input + " составляет: " + converted);
        } else {
            System.out.println("Данная валюта отсутсвует.");
        }
    }
}
