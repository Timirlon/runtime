package Lesson19.homework.task_tracker;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    private int uniqueId = 1;
    private HashMap<Integer, Task> tasks = new HashMap<>();;
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HistoryManager historyManager;

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    public Task getTaskById (int id) {
        if(tasks.containsKey(id)) {
            historyManager.add(tasks.get(id));
            System.out.println("Название задания: " + tasks.get(id).getTitle());
            return tasks.get(id);
        }
        System.out.println("Задача не найдена.");
        return null;
    }

    public Epic getEpicById (int id) {
        if(epics.containsKey(id)) {
            historyManager.add(epics.get(id));
            System.out.println("Название задания: " + epics.get(id).getTitle());
            return epics.get(id);
        }
        System.out.println("Эпик не найден.");
        return null;
    }

    public Subtask getSubtaskById (int id) {
        if(subtasks.containsKey(id)) {
            historyManager.add(subtasks.get(id));
            System.out.println("Название задания: " + subtasks.get(id).getTitle());
            return subtasks.get(id);
        }
        System.out.println("Подзадача не найдена.");
        return null;
    }

    public void update (int id, Task updatedTask) {
        if (tasks.containsKey(id)) {
            tasks.put(id, updatedTask);
            System.out.println("Задача обновлена.");
            return;
        }
        System.out.println("Задача не найдена.");
    }

    public void removeTaskById (int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            System.out.println("Задача удалена.");
            return;
        }
        System.out.println("Задача не найдена.");
    }

    public void removeEpicById (int id) {
        if (epics.containsKey(id)) {
            epics.remove(id);
            System.out.println("Эпик удален.");
            return;
        }
        System.out.println("Эпик не найден.");
    }

    public void removeSubtaskById (int id) {
        if (subtasks.containsKey(id)) {
            subtasks.remove(id);
            System.out.println("Подзадача удалена.");
            return;
        }
        System.out.println("Подзадача не найден.");
    }

    public void createTask(Task task) {
        int newId = getUniqueId();
        task.setId(newId);
        tasks.put(newId, task);
    }

    public void createEpic(Epic epic) {
        int newId = getUniqueId();
        epic.setId(newId);
        epics.put(newId, epic);
    }

    public void createSubtask(Subtask subtask) {
        if (epics.containsValue(subtask.getEpic())) {
            int newId = getUniqueId();
            subtask.setId(newId);
            subtasks.put(newId, subtask);
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
