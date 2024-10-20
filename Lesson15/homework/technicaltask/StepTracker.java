package Lesson15.homework.technicaltask;

import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    public StepTracker (Scanner newScanner) {
        newScanner = new Scanner(System.in);

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay (Scanner newScanner) {
        System.out.print("Введите номер месяца: ");
        int month = newScanner.nextInt();
        System.out.print("Введите день от 1 до 30 (включительно): ");
        int day = newScanner.nextInt();
        System.out.print("Введите количество шагов: ");
        int step = newScanner.nextInt();

        if (month >= 1 && month <= 12 && day >= 1 && day <= 30 && step > 0) {
            MonthData monthData = monthToData[month - 1];
            monthData.days[day - 1] = step;

            System.out.print("Было добавлено " + step + " шагов на дату " + (day < 10 ? 0 : "") + day + "." + (month < 10 ? 0 : "") + month);


        } else {
            System.out.println("Введены некорректные данные.");
        }
    }

    void changeStepGoal (Scanner newScanner) {
        System.out.println("Текущая цель: " + goalByStepsPerDay);
        System.out.print("Введите новую цель: ");
        int newGoal = newScanner.nextInt();

        if (newGoal > 0) {
            goalByStepsPerDay = newGoal;
            System.out.println("Новая цель сохранена.");
        } else {
            System.out.println("Введены некорректные данные.");
        }
    }

    void printStatistic (Scanner newScanner) {
        System.out.print("Выберите месяц: ");
        int month = newScanner.nextInt();

        if (month >= 1 && month <= 12) {
            MonthData monthData = monthToData[month - 1];

            monthData.printDaysAndStepsFromMonth();
            System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
            System.out.println("Максимальное пройденное количество шагов в день: " + monthData.maxSteps());
            System.out.println("Среднее количество шагов в день: " + (monthData.sumStepsFromMonth() / 30) );
            System.out.println("Пройденная дистанция за месяц в км: " + converter.convertToKm(monthData.sumStepsFromMonth()));
            System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
            System.out.println("Лучшая серия за месяц: " + monthData.bestSeries(goalByStepsPerDay));
        } else {
            System.out.println("Некорректный номер месяца.");
        }
    }
}
