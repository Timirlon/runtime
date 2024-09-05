package Lesson43_time_and_date_formatter.homework.task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, LocalDate> friends = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean loopIsActive = true;

        while (loopIsActive) {
            printMenu();
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addFriend(friends, scanner);
                    break;
                case 2:
                    findDaysTillBirthday(friends, scanner);
                    break;
                case 3:
                    printFriends(friends);
                    break;
                case 0:
                    loopIsActive = false;
                    break;
                default:
                    System.out.println("Некорректная команда.");
            }
        }
    }

    static void printMenu() {
        System.out.println("1 - Добавить друга");
        System.out.println("2 - Узнать сколько дней осталось до дня рождения друга");
        System.out.println("3 - Вывод всех друзей");
        System.out.println("0 - Выйти");
    }

    static void addFriend(Map<String, LocalDate> map, Scanner scanner) {
        System.out.print("Введите имя друга: ");
        String friendsName = scanner.nextLine();
        System.out.print("Введите дату рождения друга (год месяц день): ");
        String stringDate = scanner.nextLine();

        LocalDate correctDate = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy MM dd"));

        map.put(friendsName, correctDate);
        System.out.println("Друг добавлен.");
    }

    static void findDaysTillBirthday(Map<String, LocalDate> map, Scanner scanner) {
        if (map.isEmpty()) {
            System.out.println("Сначала добавьте друзей!");
            return;
        }

        System.out.print("Введите имя друга: ");
        String friendsName = scanner.nextLine();

        LocalDate birthDate = map.get(friendsName);
        LocalDate now = LocalDate.now();

        for (int i = 0; i < 120; i++) {
            if (birthDate.isAfter(now)) {
                long period = ChronoUnit.DAYS.between(now, birthDate);
                System.out.println("Осталось " + period + " дней. Исполнится " + i);
                return;
            }
            birthDate = birthDate.plusYears(1);
        }
        System.out.println("Дата рождения указана слишком рано.");
    }

    static void printFriends(Map<String, LocalDate> map) {
        if (map.isEmpty()) {
            System.out.println("Сначала добавьте друзей!");
            return;
        }

        String[] months = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        System.out.println("Список друзей: ");
        for (Map.Entry<String, LocalDate> entry : map.entrySet()) {
            String friendsName = entry.getKey();
            LocalDate friendsBirthDate = entry.getValue();

            System.out.println(friendsName + " - " + friendsBirthDate.getYear() + " " + months[friendsBirthDate.getMonthValue() - 1] + " " + friendsBirthDate.getDayOfMonth());
        }
    }
}
