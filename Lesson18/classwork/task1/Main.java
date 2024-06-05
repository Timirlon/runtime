package Lesson18.classwork.task1;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setMoneyAmount(40000);
        System.out.println("Количество денег на счету - " + bankAccount.getMoneyAmount() + " тг.");
        bankAccount.withdrawAll();
        System.out.println("Количество денег на счету - " + bankAccount.getMoneyAmount() + " тг.");
    }
}
