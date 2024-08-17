package Lesson38_writer_and_reader.homework.task1;

public class YearlyTransaction {
    int month;
    int amount;
    boolean isExpense;

    public YearlyTransaction(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
