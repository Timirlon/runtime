package Lesson19.homework;

import java.util.ArrayList;

public class Manager {
    private int uniqueId = 1;
    private ArrayList<Task> tasks = new ArrayList<>();;
    private ArrayList<Epic> epics = new ArrayList<>();
    private ArrayList<Subtask> subtasks = new ArrayList<>();

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Epic> getEpics() {
        return epics;
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    public Task getTaskById (int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println("Название задания: " + task.getTitle());
                return task;
            }
        }
        System.out.println("Задача не найдена.");
        return null;
    }

    public Epic getEpicById (int id) {
        for (Epic epic : epics) {
            if (epic.getId() == id) {
                System.out.println("Название задания: " + epic.getTitle());
                return epic;
            }
        }
        System.out.println("Эпик не найден.");
        return null;
    }

    public Subtask getSubtaskById (int id) {
        for (Subtask subtask : subtasks) {
            if (subtask.getId() == id) {
                System.out.println("Название задания: " + subtask.getTitle());
                return subtask;
            }
        }
        System.out.println("Подзадача не найдена.");
        return null;
    }

    public void update (int id, Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task = updatedTask;
                System.out.println("Задача обновлена.");
                return;
            }
        }
        System.out.println("Задача не найдена.");
    }

    public void removeTaskById (int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Задача удалена.");
                return;
            }
        }
        System.out.println("Задача не найдена.");
    }

    public void removeEpicById (int id) {
        for (Epic epic : epics) {
            if (epic.getId() == id) {
                epics.remove(epic);
                System.out.println("Эпик удален.");
                return;
            }
        }
        System.out.println("Эпик не найден.");
    }

    public void removeSubtaskById (int id) {
        for (Subtask subtask : subtasks) {
            if (subtask.getId() == id) {
                subtasks.remove(subtask);
                System.out.println("Подзадача удалена.");
                return;
            }
        }
        System.out.println("Подзадача не найден.");
    }

    public void createTask(Task task) {
        task.setId(getUniqueId());
        tasks.add(task);
    }

    public void createEpic(Epic epic) {
        epic.setId(getUniqueId());
        epics.add(epic);
    }

    public void createSubtask(Subtask subtask) {
        if (epics.contains(subtask.getEpic())) {
            subtask.setId(getUniqueId());
            subtasks.add(subtask);
            return;
        }
        System.out.println("Эпик не найден.");
    }

    public ArrayList<Subtask> getSubtasksByEpic(Epic epic) {
        return epic.getSubtasks();
    }

    private int getUniqueId() {
        return uniqueId++;
    }
}
