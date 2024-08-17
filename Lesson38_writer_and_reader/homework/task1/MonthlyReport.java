package Lesson38_writer_and_reader.homework.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MonthlyReport {
    private List<MonthlyTransaction> transactions = new ArrayList<>();

    public void read(int i) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Lesson38_writer_and_reader\\homework\\task1\\m.20210" + i + ".csv"));

        br.readLine();
        while (br.ready()) {
            String line = br.readLine();
            String[] split = line.split(",");
            transactions.add(new MonthlyTransaction(split[0], Boolean.parseBoolean(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])));
        }
    }

    public int calculateTotalProfitAmount () {
        int totalAmount = 0;
        for (MonthlyTransaction transaction : transactions) {
            if (transaction.isExpense) {
                totalAmount -= transaction.calculateTotalAmount();
            } else {
                totalAmount += transaction.calculateTotalAmount();
            }
        }
        return totalAmount;
    }

    public MonthlyTransaction findMostProfitableItem() {
        MonthlyTransaction mostProfitableItem = transactions.get(0);

        for (MonthlyTransaction transaction : transactions) {
            if (!transaction.isExpense && transaction.calculateTotalAmount() > mostProfitableItem.calculateTotalAmount()) {
                mostProfitableItem = transaction;
            }
        }

        return mostProfitableItem;
    }

    public MonthlyTransaction findTheBiggestExpense() {
        MonthlyTransaction biggestExpense = transactions.get(0);

        for (MonthlyTransaction transaction : transactions) {
            if (transaction.isExpense && transaction.calculateTotalAmount() > biggestExpense.calculateTotalAmount()) {
                biggestExpense = transaction;
            }
        }

        return biggestExpense;
    }
}
