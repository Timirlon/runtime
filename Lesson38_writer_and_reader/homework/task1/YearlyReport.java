package Lesson38_writer_and_reader.homework.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YearlyReport {
    private List<YearlyTransaction> yearlyData = new ArrayList<>();

    public void read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Lesson38_writer_and_reader\\homework\\task1\\y.2021.csv"));

        br.readLine();
        while (br.ready()) {
            String line = br.readLine();
            String[] split = line.split(",");
            yearlyData.add(new YearlyTransaction(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Boolean.parseBoolean(split[2])));
        }
    }

    public int calculateMonthlyProfitAmount (int monthNumber) {
        int profitAmount = 0;
        YearlyTransaction expense = yearlyData.get(0);
        YearlyTransaction income = yearlyData.get(0);

        for (YearlyTransaction monthlyData : yearlyData) {
            if (monthlyData.month == monthNumber && monthlyData.isExpense) {
                expense = monthlyData;
            }

            if (monthlyData.month == monthNumber && !monthlyData.isExpense) {
                income = monthlyData;
            }
        }

        return income.amount - expense.amount;
    }
}
