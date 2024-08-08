package Lesson35_string_format_and_exceptions.classwork.task1_format;

public class Test {
    public static void main(String[] args) {
        User[] users = {
                new User("Игорь", 25),
                new User("Афанасий", 26),
                new User("Бартоломею", 27),
                new User("Абдрахман", 29),
                new User("Али", 29),
        };

        int maxNameLength = users[0].name().length();
        for (User user : users) {
            if (user.name().length() > maxNameLength) {
                maxNameLength = user.name().length();
            }
        }

        System.out.printf("%-" + maxNameLength + "s   %s \n", "Имя", "Возраст");
        for (User user : users) {
            System.out.printf("%-" + maxNameLength + "s   %d \n", user.name(), user.age());
        }
        // Имя         Возраст
        // Игорь       25
        // Афанасий    26
        // Бартоломею  27
        // Абдрахман   29
        // Али         29
    }
}

record User(String name, int age) {
}

