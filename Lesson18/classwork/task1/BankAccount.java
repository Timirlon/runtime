package Lesson18.classwork.task1;

public class BankAccount {
    private long moneyAmount;

    public long getMoneyAmount () {
        return moneyAmount;
    }

    public void setMoneyAmount (long newMoneyAmount) {
        moneyAmount = newMoneyAmount;
    }

    public void withdrawAll () {
        System.out.println("Со счета снято " + moneyAmount + " тг.");
        moneyAmount = 0;
    }
}
