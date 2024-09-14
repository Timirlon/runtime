package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.*;

import java.util.Collection;
import java.util.List;

public interface TaskManager {
    List<Task> getHistory();

    Collection<Task> getTasks();

    Collection<Epic> getEpics();

    Collection<Subtask> getSubtasks();

    void removeAll();

    Task getTaskById (int id);

    Epic getEpicById (int id);

    Subtask getSubtaskById (int id);

    void update (int id, Task updatedTask);

    void removeTaskById (int id);

    void removeEpicById (int id);

    void removeSubtaskById (int id);

    void createTask(Task task);

    void createEpic(Epic epic);

    void createSubtask(Subtask subtask);

    List<Subtask> getSubtasksByEpic(Epic epic);
}
