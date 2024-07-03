package Lesson19.homework.task_tracker;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    List<Task> history = new ArrayList<>();
    List<Task> getHistory();
}
