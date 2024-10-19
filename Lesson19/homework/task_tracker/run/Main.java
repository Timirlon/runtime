package Lesson19.homework.task_tracker.run;

import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.service.*;
import Lesson19.homework.task_tracker.utils.Managers;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskManager taskManager = FileBackedTaskManager.loadFromFile(Managers.getPath());

        Epic cleaning = new Epic("Убраться дома", "Описание эпика");
        taskManager.createEpic(cleaning);

        Task school = new Task("Сходить в школу", "Описание задачи", LocalDateTime.of(2024, 10, 2, 10, 0), 300);
        Task groceries = new Task("Купить продукты", "Описание задачи", LocalDateTime.of(2024, 9, 27, 5, 0), 60);
        taskManager.createTask(school);
        taskManager.createTask(groceries);

        Subtask laundry = new Subtask("Стирка", "Описание подзадачи", LocalDateTime.of(2024, 10, 15, 14, 0), 60, cleaning);
        System.out.println(cleaning.getStartTime() + ", " + cleaning.getDuration());

        Subtask dishes = new Subtask("Помыть посуду", "Описание подзадачи", LocalDateTime.of(2024, 10, 15, 12, 0), 60, cleaning);
        System.out.println(cleaning.getStartTime() + ", " + cleaning.getDuration());

        System.out.println(taskManager.getPrioritizedTasks());
    }
}
