package Lesson29_hashMap.classwork.task2;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Boolean> todos = new HashMap<>();

        todos.put("Выучить Java", true);
        todos.put("Найти классную работу", false);
        todos.clear();

        System.out.println("Todo-список пуст? Ответ: " + todos.isEmpty());

    }
}
