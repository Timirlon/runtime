package Lesson36_exceptions.homework.task2;

import java.util.Scanner;

public class Main {
    static final int VALID_AGE = 18;

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        //Проверить логин и пароль
        User user = getUserByLoginAndPassword(login, password);
        //Вызвать методы валидации пользователя
        validateUser(user);

        System.out.println("Доступ предоставлен.");
    }


    public static User[] getUsers() {
        return new User[]{
                new User("Jhon", "jhon@gmail.com", "pass", 24),
                new User("Omirjhon", "omirjhon@gmail.com", "****", 18),
                new User("Bekzot", "bekzot@mail.ru", "bigzot", 17),
                new User("Jhon2", "jhonofficial@gmail.com", "pass", 25)
        };
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден.");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age < VALID_AGE) {
            throw new AccessDeniedException("Доступ запрещен. Вам меньше 18 лет.");
        }
    }
}
