package Lesson30_linkedHashMap.homework.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Practice {
    private static List<User> users = new ArrayList<>();
    private static Map<Long, User> usersMap = new HashMap<>();

    public static void main(String[] args) {
        // создадим 1 миллион пользователей
        for (long i = 1; i <= 1_000_000L; i++) {
            users.add(new User(i, "Имя " + i));
            usersMap.put(i, new User(i, "Имя " + i));
        }

        final long startTime = System.nanoTime();
        User user = findUser(378_366L);
        final long endTime = System.nanoTime();

        final long startTimeMap = System.nanoTime();
        user = usersMap.get(378_366L);
        final long endTimeMap = System.nanoTime();

        System.out.println("Найден пользователь: " + user);
        System.out.println("Поиск до оптимизации занимал " + (endTime - startTime) + " наносекунд.");
        System.out.println("Поиск после оптимизации занял " + (endTimeMap - startTimeMap) + " наносекунд.");
        System.out.println("Удалось сократить время поиска в " + ((endTime - startTime) / (endTimeMap - startTimeMap)) + " раз.");
    }

    private static User findUser(Long userId) {
        for (User user : users) {
            if (user.id.equals(userId)) {
                return user;
            }
        }

        return null;
    }

    static class User {
        Long id;
        String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "User{id=" + id + ", name='" + name + "'}";
        }
    }
}