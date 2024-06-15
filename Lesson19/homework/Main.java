package Lesson19.homework;

public class Main {
    public static void main(String[] args) {
        Manager taskManager = new Manager();

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
        school.setStatus("DONE");
        System.out.println(school.getStatus());

        System.out.println(dishes.getStatus() + " " + cleaning.getStatus());
        dishes.setStatus("DONE");
        System.out.println(dishes.getStatus() + " " + cleaning.getStatus());

        System.out.println(packing.getStatus() + " " + movingOut.getStatus());
        packing.setStatus("DONE");
        System.out.println(packing.getStatus() + " " + movingOut.getStatus());

        taskManager.removeSubtaskById(7);
    }
}
