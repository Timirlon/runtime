package Lesson19.homework.task_tracker.run;

import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.service.TaskManager;
import Lesson19.homework.task_tracker.utils.Managers;

public class Main {
    public static void main(String[] args) {
        TaskManager taskInMemoryTaskManager = Managers.getDefault();

        Task school = new Task("Сходить в школу", "Описание задачи");
        Task groceries = new Task("Купить продукты", "Описание задачи");
        taskInMemoryTaskManager.createTask(school);
        taskInMemoryTaskManager.createTask(groceries);

        System.out.println(taskInMemoryTaskManager.getTasks());


        Epic cleaning = new Epic("Убраться дома", "Описание эпика");
        taskInMemoryTaskManager.createEpic(cleaning);
        Epic movingOut = new Epic("Переезд", "Описание эпика");
        taskInMemoryTaskManager.createEpic(movingOut);

        System.out.println(taskInMemoryTaskManager.getEpics());

        Subtask dishes = new Subtask("Помыть посуду", "Описание подзадачи", cleaning);
        Subtask vacuum = new Subtask("Пропылесосить", "Описание подзадачи", cleaning);
        Subtask packing = new Subtask("Упаковать вещи", "Описание подзадачи", movingOut);
        taskInMemoryTaskManager.createSubtask(dishes);
        taskInMemoryTaskManager.createSubtask(vacuum);
        taskInMemoryTaskManager.createSubtask(packing);

        System.out.println(taskInMemoryTaskManager.getSubtasks());

        System.out.println(school.getStatus());
        school.setStatus(Status.DONE);
        System.out.println(school.getStatus());

        System.out.println(dishes.getStatus() + " " + cleaning.getStatus().name());
        dishes.setStatus(Status.DONE);
        System.out.println(dishes.getStatus() + " " + cleaning.getStatus().name());

        System.out.println(packing.getStatus() + " " + movingOut.getStatus().name());
        packing.setStatus(Status.DONE);
        System.out.println(packing.getStatus() + " " + movingOut.getStatus().name());

        taskInMemoryTaskManager.removeSubtaskById(5);

        System.out.println(taskInMemoryTaskManager.getHistory());
    }
}
