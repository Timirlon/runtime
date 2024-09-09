package Lesson11.Bank;
public class Test {
    public static void main(String[] args) {
        BankAccount firstAccount = new BankAccount();
        firstAccount.cardNumber = "KZT44003142436435";
        firstAccount.deposit(2500, "KZT");

        BankAccount secondAccount = new BankAccount();
        secondAccount.cardNumber = "KZT44003142436436";

        firstAccount.transfer(secondAccount, 2500);
        System.out.println(firstAccount.balance);
        System.out.println(secondAccount.balance);

        Product firstProduct = new Product();
        firstProduct.name = "Coca Cola";
        firstProduct.price = 419;

        Product secondProduct = new Product();
        secondProduct.name = "Pringles";
        secondProduct.price = 2000;

        firstAccount.buy(firstProduct);
        firstProduct.compareTo(secondProduct);
    }
}
