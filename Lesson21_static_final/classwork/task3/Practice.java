package Lesson21_staticFinal.classwork.task3;

import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionValidator transactionValidator = new TransactionValidator();

        System.out.println("Пожалуйста, введите сумму перевода в тенге.");
        int amount = scanner.nextInt();

        boolean isValid = transactionValidator.isValidAmount(amount);
        if (isValid)
            System.out.println("Спасибо! Ваш перевод на сумму " + amount + " тг. успешно выполнен.");
    }
}
