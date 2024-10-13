package Lesson19.homework.task_tracker.run;

import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.service.InMemoryTaskManager;
import Lesson19.homework.task_tracker.service.TaskManager;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        TaskManager taskManager = new InMemoryTaskManager();

        Epic cleaning = new Epic("Убраться дома", "Описание эпика");
        taskManager.createEpic(cleaning);
        Epic movingOut = new Epic("Переезд", "Описание эпика");
        taskManager.createEpic(movingOut);

        Task school = new Task("Сходить в школу", "Описание задачи", LocalDateTime.of(2004, 2, 2, 10, 10, 41), 300);
        Task groceries = new Task("Купить продукты", "Описание задачи", LocalDateTime.of(2009, 6, 27, 5, 1, 3), 60);
        taskManager.createTask(school);
        taskManager.createTask(groceries);

        System.out.println(taskManager.getPrioritizedTasks());
    }
}
