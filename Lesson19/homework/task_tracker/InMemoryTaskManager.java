package Lesson19.homework.task_tracker;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    private int uniqueId = 1;
    private Map<Integer, Task> tasks = new HashMap<>();;
    private Map<Integer, Epic> epics = new HashMap<>();
    private Map<Integer, Subtask> subtasks = new HashMap<>();
    private HistoryManager historyManager = new InMemoryHistoryManager();

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    @Override
    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public Map<Integer, Epic> getEpics() {
        return epics;
    }

    @Override
    public Map<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    @Override
    public Task getTaskById(int id) {
        if(tasks.containsKey(id)) {
            historyManager.add(tasks.get(id));
            return tasks.get(id);
        }
        System.out.println("Задача не найдена.");
        return null;
    }

    @Override
    public Epic getEpicById(int id) {
        if(epics.containsKey(id)) {
            historyManager.add(epics.get(id));
            return epics.get(id);
        }
        System.out.println("Эпик не найден.");
        return null;
    }

    @Override
    public Subtask getSubtaskById(int id) {
        if(subtasks.containsKey(id)) {
            historyManager.add(subtasks.get(id));
            return subtasks.get(id);
        }
        System.out.println("Подзадача не найдена.");
        return null;
    }

    @Override
    public void update (int id, Task updatedTask) {
        if (tasks.containsKey(id)) {
            tasks.put(id, updatedTask);
            System.out.println("Задача обновлена.");
            historyManager.add(tasks.get(id));
            return;
        }
        System.out.println("Задача не найдена.");
    }

    @Override
    public void removeTaskById (int id) {
        if (tasks.containsKey(id)) {
            historyManager.add(tasks.get(id)); //добавляем в историю
            tasks.remove(id);
            System.out.println("Задача удалена.");
            return;
        }
        System.out.println("Задача не найдена.");
    }

    @Override
    public void removeEpicById (int id) {
        if (epics.containsKey(id)) {
            historyManager.add(epics.get(id)); //добавляем в историю
            epics.remove(id);
            System.out.println("Эпик удален.");
            return;
        }
        System.out.println("Эпик не найден.");
    }

    @Override
    public void removeSubtaskById (int id) {
        if (subtasks.containsKey(id)) {
            historyManager.add(subtasks.get(id)); //добавляем в историю
            subtasks.remove(id);
            System.out.println("Подзадача удалена.");
            return;
        }
        System.out.println("Подзадача не найден.");
    }

    @Override
    public void createTask(Task task) {
        int newId = getUniqueId();
        task.setId(newId);
        tasks.put(newId, task);
        historyManager.add(task);
    }

    @Override
    public void createEpic(Epic epic) {
        int newId = getUniqueId();
        epic.setId(newId);
        epics.put(newId, epic);
        historyManager.add(epic);
    }

    @Override
    public void createSubtask(Subtask subtask) {
        if (epics.containsValue(subtask.getEpic())) {
            int newId = getUniqueId();
            subtask.setId(newId);
            subtasks.put(newId, subtask);
            historyManager.add(subtask);
            return;
        }
        System.out.println("Эпик не найден.");
    }

    @Override
    public List<Subtask> getSubtasksByEpic(Epic epic) {
        return epic.getSubtasks();
    }

    private int getUniqueId() {
        return uniqueId++;
    }
}