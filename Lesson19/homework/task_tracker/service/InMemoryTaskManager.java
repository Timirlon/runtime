package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.utils.StartTimeComparator;
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
    public List<Task> getPrioritizedTasks() {
        List<Task> prioritizedTasks = new ArrayList<>();

        prioritizedTasks.addAll(getTasks());
        prioritizedTasks.addAll(getEpics());
        prioritizedTasks.addAll(getSubtasks());

        prioritizedTasks.sort(new StartTimeComparator());

        return prioritizedTasks;
    }

    @Override
    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
        historyManager.removeAll();
    }

    protected Task get(int id) {
        Task requestedTask;

        if (tasks.containsKey(id)) {
            requestedTask = tasks.get(id);
        } else if (epics.containsKey(id)) {
            requestedTask = epics.get(id);
        } else {
            requestedTask = subtasks.get(id);
        }

        return requestedTask;
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

        updatedTask = get(id);

        return updatedTask;
    }

    @Override
    public Task removeTask(int id) {
        return tasks.remove(id);
    }

    @Override
    public Epic removeEpic(int id) {
        Epic epic = epics.get(id);

        if (epic != null) {
            for (Subtask subtask : epic.getSubtasks()) {
                subtasks.remove(subtask.getId());
            }
        }

        return epics.remove(id);
    }

    @Override
    public Subtask removeSubtask(int id) {
        Subtask subtask = subtasks.get(id);

        if (subtask != null) {
            subtask.getEpic().getSubtasks().remove(subtask);
        }

        return subtasks.remove(id);
    }

    @Override
    public Task createTask(Task task) {
        if (!isTaskTimeNotIntersecting(task)) {
            return null;
        }

        int newId = getUniqueId();
        task.setId(newId);
        tasks.put(newId, task);

        return task;
    }

    @Override
    public Epic createEpic(Epic epic) {
        if (!isTaskTimeNotIntersecting(epic)) {
            return null;
        }

        int newId = getUniqueId();
        epic.setId(newId);
        epics.put(newId, epic);

        return epic;
    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        if (!isTaskTimeNotIntersecting(subtask)) {
            return null;
        }

        if (epics.containsValue(subtask.getEpic())) {
            int newId = getUniqueId();
            subtask.setId(newId);
            subtasks.put(newId, subtask);

            return subtask;
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

    private boolean isTaskTimeNotIntersecting(Task task) {
        boolean isNotIntersecting = true;

        for (int i = 1; i < uniqueId; i++) {
            isNotIntersecting = isTimeOfTwoTasksMutuallyNotIntersecting(task, get(i));

            if (!isNotIntersecting) {
                break;
            }
        }

        return isNotIntersecting;
    }

    private boolean isTimeOfTwoTasksMutuallyNotIntersecting(Task taskOne, Task taskTwo) {
        if (taskTwo == null || taskTwo.getStartTime() == null) {
            return true;
        }

        if (taskOne.getStartTime() == null) {
            return false;
        }

        if (taskOne.getType() == Type.SUBTASK && taskTwo.getType() == Type.EPIC) {
            Subtask subtask = (Subtask) taskOne;

            if (subtask.getEpic() == taskTwo) {
                return true;
            }
        }

        if (taskOne.getStartTime().equals(taskTwo.getStartTime()) || taskOne.getEndTime().equals(taskTwo.getEndTime())) {
            return false;
        }

        if (taskOne.getStartTime().isAfter(taskTwo.getStartTime()) && taskOne.getStartTime().isBefore(taskTwo.getEndTime())) {
            return false;
        }

        if (taskOne.getEndTime().isAfter(taskTwo.getStartTime()) && taskOne.getEndTime().isBefore(taskTwo.getEndTime())) {
            return false;
        }

        return true;
    }
}