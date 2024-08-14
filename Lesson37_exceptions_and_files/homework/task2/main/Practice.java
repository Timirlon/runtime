package Lesson37_exceptions_and_files.homework.task2.main;

import Lesson37_exceptions_and_files.homework.task2.exceptions.ValidateException;
import Lesson37_exceptions_and_files.homework.task2.exceptions.ValidateNameException;
import Lesson37_exceptions_and_files.homework.task2.exceptions.ValidatePasswordException;
import Lesson37_exceptions_and_files.homework.task2.storage.PasswordMemoryStorage;
import Lesson37_exceptions_and_files.homework.task2.storage.PasswordStorage;
import Lesson37_exceptions_and_files.homework.task2.validators.NameValidator;
import Lesson37_exceptions_and_files.homework.task2.validators.PasswordLengthValidator;
import Lesson37_exceptions_and_files.homework.task2.validators.PasswordStrengthValidator;
import Lesson37_exceptions_and_files.homework.task2.validators.Validator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Practice {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Validator> passwordValidators = List.of(
            new PasswordLengthValidator(5), new PasswordStrengthValidator()
    );

    private static final List<Validator> nameValidators = List.of(new NameValidator()); // поработайте со списком

    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        while (true) {
            final String action = getAction();
            if ("1".equals(action)) {
                addUser();
            } else if ("2".equals(action)) {
                showUserPassword();
            } else {
                break;
            }
        }
    }

    private static void checkValidatorRules(
            final List<Validator> validators, final String value
    ) throws ValidateException {
        for (Validator validator : validators) {
            validator.validate(value);
        }
    }

    private static void addUser() {
        final PasswordStorage storage = new PasswordMemoryStorage();
        // добавьте отлов исключений ValidateNameException и ValidatePasswordException
        // закройте хранилище
        try {
            storage.open();
            System.out.println("Введите имя пользователя => ");
            final String name = scanner.nextLine();
            try {
                checkValidatorRules(nameValidators, name);
            } catch (ValidateNameException e) {
                System.out.println("Ошибка валидации:" + e.getMessage());
            }
            System.out.println("Введите пароль пользователя => ");
            final String password = scanner.nextLine();
            try {
                checkValidatorRules(passwordValidators, password);
            } catch (ValidatePasswordException e) {
                System.out.println("Ошибка валидации:" + e.getMessage());
            }
            storage.store(name, password);
        } catch (ValidateException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка работы с хранилищем: " + e.getMessage());
        } finally {
            storage.close();
        }
    }

    private static void showUserPassword() {
        final PasswordStorage storage = new PasswordMemoryStorage();
        // добавьте отлов исключения ValidateNameException
        // закройте хранилище
        try {
            storage.open();
            System.out.println("Введите имя пользователя => ");
            final String name = scanner.nextLine();
            try {
                checkValidatorRules(nameValidators, name);
            } catch (ValidateNameException e) {
                System.out.println("Ошибка валидации:" + e.getMessage());
            }
            final String password = storage.get(name);
            System.out.printf("Пароль пользователя %s = %s%n", name, password);
        } catch (ValidateException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка работы с хранилищем: " + e.getMessage());
        } finally {
            storage.close();
        }
    }

    private static String getAction() {
        System.out.println("1 - добавить пользователя с паролем");
        System.out.println("2 - отобразить пароль пользователя");
        System.out.println("другие символы - выход");
        System.out.println("Выберите действие => ");
        return scanner.nextLine();
    }
}
