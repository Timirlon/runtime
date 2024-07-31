package Lesson19.homework.task_tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TaskManager {
    List<Task> getHistory();

    HashMap<Integer, Task> getTasks();

    HashMap<Integer, Epic> getEpics();

    HashMap<Integer, Subtask> getSubtasks();

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

    ArrayList<Subtask> getSubtasksByEpic(Epic epic);
}
