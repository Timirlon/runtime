package Lesson38_writer_and_reader.homework.task1;

public class MonthlyTransaction {
    String name;
    boolean isExpense;
    int price;
    int amount;

    public MonthlyTransaction(String name, boolean isExpense, int price, int amount) {
        this.name = name;
        this.isExpense = isExpense;
        this.price = price;
        this.amount = amount;
    }

    public int calculateTotalAmount() {
        return price * amount;
    }
}
