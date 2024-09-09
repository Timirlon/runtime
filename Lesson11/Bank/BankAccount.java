package Lesson11.Bank;
public class BankAccount {
    String cardNumber;
    double balance;

    double rateUSD = 450;
    double rateEUR = 500;
    double rateRUB = 4.82;

    void deposit(double money, String currency) {
        double tenge = convert(money, currency);
        balance += tenge;
        System.out.println("Счет пополнен на " + tenge + " тенге.");
        System.out.println("Счет пополнен на " + money + " " + currency);
    }

    void withdraw(double money, String currency) {
        double tenge = convert(money, currency);
        if (balance < tenge) {
            System.out.println("Недостаточно средств");
        } else {
            balance -= tenge;
            System.out.println("Покупка составила: " + tenge + " тенге.");
            System.out.println("Покупка составила: " + money + " " + currency);
        }
    }

    double convert(double amount, String currency) {
        return switch (currency) {
            case "USD" -> amount * rateUSD;
            case "EUR" -> amount * rateEUR;
            case "RUB" -> amount * rateRUB;
            default -> amount;
        };
    }

    void transfer(BankAccount user, double money) {
        if(balance >= money) {
            balance -= money;
            user.balance += money;
            System.out.println("На карту " + user.cardNumber + " поступил перевод с карты " +
                    cardNumber + " в размере " + money + " тенге");
        } else {
            System.out.println("Недостаточно средств для операции.");
        }
    }

    void buy(Product product) {
        if(balance >= product.price) {
            balance -= product.price;
            System.out.println("Товар " + product.name + " куплен. Баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств для операции.");
        }
    }

}


