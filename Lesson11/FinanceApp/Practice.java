package Lesson11.FinanceApp;

import java.util.Scanner;
public class Practice {
    public static void main(String[] args) {
        double[] expenses = new double[7];

        Scanner scanner = new Scanner(System.in);

        Converter converter = new Converter();

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Ваши сбережения: " + moneyBeforeSalary + " KZT");
                System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - JPY.");
                int currency = scanner.nextInt();

                converter.convert(moneyBeforeSalary, currency);
            } else if (command == 2) {
                getAdvice(moneyBeforeSalary, daysBeforeSalary);
            } else if (command == 3) {
                saveExpense(moneyBeforeSalary, expenses);
            } else if (command == 4) {
                printAllExpenses(expenses);
            } else if (command == 5) {
                findMaxExpense(expenses);
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Конвертировать валюту");
        System.out.println("2 - Получить совет");
        System.out.println("3 - Ввести трату");
        System.out.println("4 - Показать траты за неделю");
        System.out.println("5 - Показать самую большую сумму расходов за неделю");
        System.out.println("0 - Выход");
    }

    static void convert(double money) {
        double rateUSD = 450;
        double rateEUR = 500;
        double rateJPY = 3;

        Scanner scanner = new Scanner(System.in);

    }

    static void getAdvice(double money, int days) {
        if (money < 10000) {
            System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
        } else if (money < 35000) {
            if (days < 10) {
                System.out.println("Окей, пора в Макдак!");
            } else {
                System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
            }
        } else if (money < 80000) {
            if (days < 10) {
                System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
            } else {
                System.out.println("Окей, пора в Макдак!");
            }
        } else {
            if (days < 10) {
                System.out.println("Отлично! Заказывайте крабов!");
            } else {
                System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
            }
        }
    }

    static void saveExpense(double money, double[] weeklyExpenses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
        int day = scanner.nextInt();
        System.out.println("Введите размер траты:");
        double expense = scanner.nextDouble();
        money = money - expense;
        weeklyExpenses[day - 1] = weeklyExpenses[day - 1] + expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в тенге: " + money);
        if (money < 5000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
    }

    static void printAllExpenses(double[] weeklyExpenses) {
        for (int i = 0; i < weeklyExpenses.length; i++) {
            System.out.println("День " + (i + 1) + ". Потрачено " + weeklyExpenses[i] + " тенге");
        }
    }

    static void findMaxExpense(double[] weeklyExpenses) {
        double maxExpense = 0;
        for (int i = 0; i < weeklyExpenses.length; i++) {
            if (weeklyExpenses[i] > maxExpense) {
                maxExpense = weeklyExpenses[i];
            }
        }
        System.out.println("Самая большая сумма расходов на этой неделе составила " + maxExpense + " тенге");
    }
}
