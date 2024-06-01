package Arraylist_Lesson16.hometask;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> toDoList = new ArrayList<>();

        while (true) {
            System.out.println("1. Добавить задачу");
            System.out.println("2. Вывести список задач");
            System.out.println("3. Удалить задачу");
            System.out.println("0. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                addTask(toDoList);
            } else if (choice == 2) {
                showTaskList(toDoList);
            } else if (choice == 3) {
                removeTask(toDoList);
            } else if (choice == 0) {
                System.out.println("Выход из программы ...");
                break;
            } else {
                System.out.println("Некорректный номер команды.");
            }
            System.out.println();
        }
    }

    static void addTask (ArrayList<String> taskList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите новую задачу: ");
        String task = scanner.nextLine();

        taskList.add(task);
        System.out.println("Задача добавлена в список.");
    }

    static void showTaskList (ArrayList<String> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("Нет запланированных дел.");
        } else {
            System.out.println("Список запланированных дел: ");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }

    static void removeTask (ArrayList<String> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задачи для удаления: ");
        int taskToRemove = scanner.nextInt();

        if(taskToRemove > 0 && taskToRemove <= taskList.size()) {
            taskList.remove(taskToRemove - 1);
            System.out.println("Задача удалена из списка.");
        } else {
            System.out.println("Некорректный номер задачи.");
        }
    }
}
