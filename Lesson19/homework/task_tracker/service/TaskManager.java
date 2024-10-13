package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.*;
import java.util.Collection;
import java.util.List;

public interface TaskManager {
    List<Task> getHistory();

    Collection<Task> getTasks();

    Collection<Epic> getEpics();

    Collection<Subtask> getSubtasks();

    List<Task> getPrioritizedTasks();

    void removeAll();

    Task getTask(int id);

    Epic getEpic(int id);

    Subtask getSubtask(int id);

    Task update(int id, Task updatedTask);

    Task removeTask(int id);

    Epic removeEpic(int id);

    Subtask removeSubtask(int id);

    Task createTask(Task task);

    Epic createEpic(Epic epic);

    Subtask createSubtask(Subtask subtask);

    List<Subtask> getSubtasksByEpic(Epic epic);
}
