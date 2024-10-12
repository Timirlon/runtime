package Lesson19.homework.task_tracker.run;

import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.service.TaskManager;
import Lesson19.homework.task_tracker.utils.Managers;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();

        Task school = new Task("Сходить в школу", "Описание задачи");
        Task groceries = new Task("Купить продукты", "Описание задачи");
        taskManager.createTask(school);
        taskManager.createTask(groceries);

        System.out.println(taskManager.getTasks());


        Epic cleaning = new Epic("Убраться дома", "Описание эпика");
        taskManager.createEpic(cleaning);
        Epic movingOut = new Epic("Переезд", "Описание эпика");
        taskManager.createEpic(movingOut);

        System.out.println(taskManager.getEpics());

        Subtask dishes = new Subtask("Помыть посуду", "Описание подзадачи", cleaning);
        Subtask vacuum = new Subtask("Пропылесосить", "Описание подзадачи", cleaning);
        Subtask packing = new Subtask("Упаковать вещи", "Описание подзадачи", movingOut);
        taskManager.createSubtask(dishes);
        taskManager.createSubtask(vacuum);
        taskManager.createSubtask(packing);

        System.out.println(taskManager.getSubtasks());

        System.out.println(school.getStatus());
        school.setStatus(Status.DONE);
        System.out.println(school.getStatus());

        System.out.println(dishes.getStatus() + " " + cleaning.getStatus().name());
        dishes.setStatus(Status.DONE);
        System.out.println(dishes.getStatus() + " " + cleaning.getStatus().name());

        System.out.println(packing.getStatus() + " " + movingOut.getStatus().name());
        packing.setStatus(Status.DONE);
        System.out.println(packing.getStatus() + " " + movingOut.getStatus().name());

        taskManager.removeSubtask(5);

        System.out.println(taskManager.getHistory());
    }
}
