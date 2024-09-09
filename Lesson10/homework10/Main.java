package Lesson10.homework10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите страну аренды: ");
        String country = scanner.next();
        System.out.print("Введите город: ");
        String city = scanner.next();
        System.out.print("Введите класс автомобиля: ");
        String carClass = scanner.next();
        System.out.print("Введите количество дней аренды автомобиля: ");
        int days = scanner.nextInt();
        System.out.print("Желаете ли вы приобрести страховку? (true/false): ");
        boolean insurance = scanner.nextBoolean();
        System.out.print("Нужно ли вам детское сиденье? (true/false): ");
        boolean childSeat = scanner.nextBoolean();

        double basePrice = calculateBasePrice(country, city, carClass);
        double daysPrice = calculateDaysPrice(basePrice, days);
        double extrasPrice = calculateExtrasPrice(insurance, childSeat) * days;
        double totalPrice = daysPrice + extrasPrice;

        System.out.println("Базовая стоимость аренды составила " + basePrice);
        System.out.println("Стоимость за дни аренды составила " + daysPrice);
        System.out.println("Стоимость дополнительных услуг составила " + extrasPrice);
        System.out.println("Итоговая стоимость составила " + totalPrice);
    }

    static double calculateBasePrice(String country, String city, String carClass) {
        double basePrice = 0;
        if (carClass.equals("Эконом")) {
            basePrice = 30;
        } else if (carClass.equals("Средний")) {
            basePrice = 50;
        } else if (carClass.equals("Бизнес")) {
            basePrice = 80;
        } else if (carClass.equals("Внедорожник")) {
            basePrice = 100;
        }

        if (country.equals("США")) {
            if(city.equals("Нью-Йорк") || city.equals("Лос-Анджелес")) {
                basePrice *= 1.3;
            } else {
                basePrice *= 1.2;
            }
        } else if (country.equals("Германия")) {
            if(city.equals("Берлин")) {
                basePrice *= 1.15;
            } else {
                basePrice *= 1.1;
            }
        }
        return basePrice;
    }

    static double calculateDaysPrice(double basePrice, int days) {
        double totalPrice = basePrice * days;
        if (days > 7) {
            totalPrice *= 0.9;
        }
        return totalPrice;
    }

    static double calculateExtrasPrice(boolean insurance, boolean childSeat) {
        double extrasPrice = 0;

        if(insurance) {
            extrasPrice += 15;
        }
        if(childSeat) {
            extrasPrice += 5;
        }

        return extrasPrice;
    }
}
