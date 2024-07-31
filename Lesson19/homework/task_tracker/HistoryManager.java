package Lesson19.homework.task_tracker;

import java.util.ArrayList;
import java.util.List;

public interface HistoryManager {

    void add(Task task);

    void remove (int id);

    List<Task> getHistory();
}
