package Lesson45_unit_test.classwork.task2;

public class BankAccount {

    private boolean isBlocked = false;
    private Integer amount;
    private String currency;

    private final String firstName;
    private final String secondName;

    public BankAccount(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void block() {
        this.isBlocked = true;
    }

    public void activate(String currency) {
        this.amount = 0;
        this.currency = currency;
    }

    public Integer getAmount() {
        if (amount == null) {
            throw new IllegalStateException("Счёт не активирован.");
        }
        return this.amount;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String[] getFullName() {
        return new String[]{firstName, secondName};
    }

    public void addToBalance(int amount) {
        this.amount += amount;
    }

    public void withdraw(int amount) {
        if (this.amount == null) {
            throw new IllegalStateException("Счёт не активирован.");
        }

        if (this.amount < amount) {
            throw new IllegalStateException("Недостаточно средств для транзакции.");
        }

        if (isBlocked) {
            throw new IllegalStateException("Счёт заблокирован.");
        }

        this.amount -= amount;
    }

    public void transfer(BankAccount otherAccount, int amount) {
        if (this.amount == null) {
            throw new IllegalStateException("Ваш счёт не активирован.");
        }

        if (amount <= 0) {
            throw new IllegalStateException("Введена некорректная сумма для перевода.");
        }

        if (this.amount < amount) {
            throw new IllegalStateException("Недостаточно средств для транзакции.");
        }

        if (isBlocked) {
            throw new IllegalStateException("Ваш счёт заблокирован.");
        }

        if (otherAccount.amount == null) {
            throw new IllegalStateException("Cчёт получателя не активирован.");
        }

        if (otherAccount.isBlocked) {
            throw new IllegalStateException("Cчёт получателя заблокирован.");
        }

        this.amount -= amount;
        otherAccount.amount += amount;
    }
}
