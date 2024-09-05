package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.Task;

import java.util.List;

public interface HistoryManager {

    void add(Task task);

    void remove (int id);

    List<Task> getHistory();
}
