package Lesson21_staticFinal.classwork.task3;

public class TransactionValidator {
    static final int MIN_AMOUNT = 100;
    static final int MAX_AMOUNT = 100000;

    static boolean isValidAmount (int amount) {
        if (amount < MIN_AMOUNT) {
            System.out.println("Минимальная сумма перевода: " + MIN_AMOUNT + " тг. Попробуйте ещё раз!");
            return false;
        } else if (amount > MAX_AMOUNT) {
            System.out.println("Максимальная сумма перевода: " + MAX_AMOUNT + " тг. Попробуйте ещё раз!");
            return false;
        }
        return true;
    }
}
