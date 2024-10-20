package Lesson15.homework.technicaltask;

public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth () {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sum = 0;
        for (int day : days) {
            sum += day;
        }
        return sum;
    }

    int maxSteps () {
        int max = days[0];
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }

    int bestSeries(int goal) {
        int count = 0;
        int curBest = 0;
        for (int day : days) {
            if (day >= goal) {
                count++;
                if (count > curBest) {
                    curBest = count;
                }
            } else {
                count = 0;
            }
        }
        return curBest;
    }
}
