package Lesson21_staticFinal.classwork.task2;

public class Registration {
    static final int PHONE_LENGTH = 11;
    static final int MIN_PASSWORD_LENGTH = 8;
    public static void validateCredentials(String phone, String password) {
        if (phone.length() != PHONE_LENGTH) {
            System.out.println("Введите номер в формате 7xxxxxxxxxxx, где x - любая цифра.");
        }
        if (password.length() < MIN_PASSWORD_LENGTH) {
            System.out.println("Минимальная длина пароля: " + MIN_PASSWORD_LENGTH + " знаков.");
        }
    }

    public static void main(String[] args) {
        validateCredentials("7901000000", "Qwerty");
    }

}
