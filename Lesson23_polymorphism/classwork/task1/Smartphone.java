package Lesson23_polymorphism.classwork.task1;

public class Smartphone extends MobilePhone {
    public Smartphone (String number) {
        super(number);
    }

    public final void sendEmail(String email, String messageText) {
        System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
    }

    public final void makeCall(String targetNumber, String appName) {
        System.out.println("Звоним с номера " + getNumber());
        System.out.println("Набираем номер " + targetNumber + " и звоним через приложение " + appName);
        System.out.println("Привет!");
    }
}
