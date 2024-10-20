package Lesson15.homework.technicaltask;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {
                stepTracker.addNewNumberStepsPerDay(scanner);
            } else if (choice == 2) {
                stepTracker.changeStepGoal(scanner);
            } else if (choice == 3) {
                stepTracker.printStatistic(scanner);
            } else if (choice == 4) {
                System.out.println("Выход из программы ...");
                break;
            } else {
                System.out.println("Некорректная команда.");
            }
            System.out.println();
        }
    }
    static void printMenu () {
        System.out.println("Выберите действие: ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определенный месяц");
        System.out.println("4 - Выйти из приложения");
    }
}
