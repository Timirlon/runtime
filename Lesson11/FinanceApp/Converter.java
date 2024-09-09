package Lesson11.FinanceApp;

public class Converter {
    double rateUSD = 450;
    double rateEUR = 500;
    double rateJPY = 3;

    void convert(double tenges, int currency) {
        switch (currency) {
            case 1 -> System.out.println("Ваши сбережение в долларах: " + tenges / rateUSD);
            case 2 -> System.out.println("Ваши сбережение в евро: " + tenges / rateEUR);
            case 3 -> System.out.println("Ваши сбережение в йенах: " + tenges / rateJPY);
            default -> System.out.println("Некорректный индекс валюты. ");
        };
    }
}
