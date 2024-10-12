package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.*;
import java.util.*;

public class InMemoryTaskManager implements TaskManager {
    protected int uniqueId = 1;
    protected Map<Integer, Task> tasks = new HashMap<>();
    protected Map<Integer, Epic> epics = new HashMap<>();
    protected Map<Integer, Subtask> subtasks = new HashMap<>();
    protected HistoryManager historyManager = new InMemoryHistoryManager();

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    @Override
    public Collection<Task> getTasks() {
        return tasks.values();
    }

    @Override
    public Collection<Epic> getEpics() {
        return epics.values();
    }

    @Override
    public Collection<Subtask> getSubtasks() {
        return subtasks.values();
    }

    @Override
    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
        historyManager.removeAll();
    }

    @Override
    public Task getTask(int id) {
        Task requestedTask = tasks.get(id);
        historyManager.add(requestedTask);

        return requestedTask;
    }

    @Override
    public Epic getEpic(int id) {
        Epic requestedEpic = epics.get(id);
        historyManager.add(requestedEpic);

        return requestedEpic;
    }

    @Override
    public Subtask getSubtask(int id) {
        Subtask requestedSubtask = subtasks.get(id);
        historyManager.add(requestedSubtask);

        return requestedSubtask;
    }

    @Override
    public Task update(int id, Task updatedValue) {
        Task updatedTask;

        if (tasks.containsKey(id)) {
            updatedTask = tasks.put(id, updatedValue);
        } else if (epics.containsKey(id)) {
            updatedTask = epics.put(id, (Epic) updatedValue);
        } else {
            updatedTask = subtasks.put(id, (Subtask) updatedValue);
        }

        return updatedTask;
    }

    @Override
    public Task removeTask(int id) {
        return tasks.remove(id);
    }

    @Override
    public Epic removeEpic(int id) {
        return epics.remove(id);
    }

    @Override
    public Subtask removeSubtask(int id) {
        return subtasks.remove(id);
    }

    @Override
    public Task createTask(Task task) {
        int newId = getUniqueId();
        task.setId(newId);

        return tasks.put(newId, task);
    }

    @Override
    public Epic createEpic(Epic epic) {
        int newId = getUniqueId();
        epic.setId(newId);

        return epics.put(newId, epic);
    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        if (epics.containsValue(subtask.getEpic())) {
            int newId = getUniqueId();
            subtask.setId(newId);

            return subtasks.put(newId, subtask);
        }

        return null;
    }

    @Override
    public List<Subtask> getSubtasksByEpic(Epic epic) {
        return epic.getSubtasks();
    }

    private int getUniqueId() {
        return uniqueId++;
    }
}