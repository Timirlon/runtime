package Lesson38_writer_and_reader.homework.task1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport[] monthlyReports = new MonthlyReport[3];
        YearlyReport yearlyReport = new YearlyReport();
        boolean loopIsTrue = true;
        boolean yearlyReportIsChecked = false;
        boolean monthlyReportIsChecked = false;

        while (loopIsTrue) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    readMonthlyReport(monthlyReports);
                    monthlyReportIsChecked = true;
                    break;
                case 2:
                    yearlyReport.read();
                    yearlyReportIsChecked = true;
                    break;
                case 3:
                    if (!monthlyReportIsChecked || !yearlyReportIsChecked) {
                        System.out.println("Недостаточно данных - сначала следует считать данные из файла.");
                        break;
                    }

                    boolean dataIsConsistent = true;
                    for (int i = 0; i < monthlyReports.length; i++) {
                        if (yearlyReport.calculateMonthlyProfitAmount(i + 1) != monthlyReports[i].calculateTotalProfitAmount()) {
                            System.out.println("Обнаружено несоответствие в месяце №" + (i == 0 ? "Январь" : i == 1 ? "Ферваль" : "Март"));
                            dataIsConsistent = false;
                        }
                    }

                    if (dataIsConsistent) {
                        System.out.println("Операция успешно выполнена. Несоответствий не выявлено.");
                    }

                    break;
                case 4:
                    if (!monthlyReportIsChecked) {
                        System.out.println("Недостаточно данных - сначала следует считать данные из файла.");
                        break;
                    }

                    for (int i = 0; i < monthlyReports.length; i++) {
                        System.out.println(i == 0 ? "Январь" : i == 1 ? "Ферваль" : "Март");
                        System.out.println("Самый прибыльный товар: " + monthlyReports[i].findMostProfitableItem().name + ", товар был продан в общей сложности в "
                                + monthlyReports[i].findMostProfitableItem().calculateTotalAmount() + " тг.");
                        System.out.println("Самая большая трата: " + monthlyReports[i].findTheBiggestExpense().name + ", трата обошлась в "
                                + monthlyReports[i].findTheBiggestExpense().calculateTotalAmount() + " тг.");

                    }
                    break;
                case 5:
                    if (!yearlyReportIsChecked) {
                        System.out.println("Недостаточно данных - сначала следует считать данные из файла.");
                        break;
                    }

                    System.out.println("2021 год");
                    System.out.println("Прибыль за январь: " + yearlyReport.calculateMonthlyProfitAmount(1));
                    System.out.println("Прибыль за февраль: " + yearlyReport.calculateMonthlyProfitAmount(2));
                    System.out.println("Прибыль за март: " + yearlyReport.calculateMonthlyProfitAmount(3));
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    loopIsTrue = false;
                    break;
                default:
                    System.out.println("Некорректная команда.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию обо всех месячных отчетах");
        System.out.println("5 - Вывести информацию о годовом отчете");
        System.out.println("0 - Выйти");
    }

    public static void readMonthlyReport(MonthlyReport[] monthlyReports) throws IOException {
        for (int i = 0; i < monthlyReports.length; i++) {
            monthlyReports[i] = new MonthlyReport();
            monthlyReports[i].read(i + 1);
        }
    }
}
