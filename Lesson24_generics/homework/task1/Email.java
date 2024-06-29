package Lesson24_generics.homework.task1;

public class Email extends Contact {
    private final String email;

    public Email(String name, String email) {
        super(name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void sendMessage() {
        System.out.println("Отправим новогоднюю картинку коллеге на электронную почту " + email);
    }

    public void print() {
        System.out.println("Email: " + getEmail());
    }
}
