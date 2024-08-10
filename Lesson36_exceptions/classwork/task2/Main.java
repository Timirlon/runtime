package Lesson36_exceptions.classwork.task2;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(validatePassword("Abcdefgh"));
        } catch (PasswordValidateException passwordValidateException) {
            System.out.println(passwordValidateException.getMessage());
        }
    }
    // PasswordValidateException
    static boolean validatePassword(String password) {
        if (password.length() < 8) {
            throw new PasswordValidateException("Пароль должен содержать как минимум 8 символов.");
        }
        boolean passwordDigit = false;
        boolean passwordUpperCase = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                passwordDigit = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                passwordUpperCase = true;
            }
        }

        if (!passwordDigit) {
            throw new PasswordValidateException("Пароль должен содержать как минимум одну цифру.");
        }

        if (!passwordUpperCase) {
            throw new PasswordValidateException("Пароль должен содержать как минимум одну заглавную букву.");
        }

        return true;
    }

}

class PasswordValidateException extends RuntimeException {
    public PasswordValidateException(String message) {
        super(message);
    }
}
