package Lesson24_generics.homework.task1;

public class Phone extends Contact {
    private final String phoneNumber;

    public Phone(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void sendMessage() {
        System.out.println("Звоним другу по номеру " + phoneNumber + " и зовем на кофе.");
    }

    public void print() {
        System.out.println("Номер телефона: " + getPhoneNumber());
    }
}
