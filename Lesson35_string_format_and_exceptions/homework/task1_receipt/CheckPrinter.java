package Lesson35_string_format_and_exceptions.homework.task1_receipt;

import java.util.Scanner;

public class CheckPrinter {
    public static void printCheck(String[] items) {
        for (String item : items) {
            String[] split = item.split(", ");

            System.out.printf("%-10s%-7s%-6s", split[0], split[1], split[2]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество записей: ");
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = new String[n];
        for (int i = 0; i < n; ++i)
            values[i] = scanner.nextLine();
        printCheck(values);
    }
}
