package Lesson24_generics.homework.task1;

import Lesson19.homework.task_tracker.InMemoryTaskManager;
import Lesson19.homework.task_tracker.Task;
import Lesson19.homework.task_tracker.TaskManager;

import java.util.List;

public class Managers {
    static TaskManager getDefault() {
        TaskManager taskManager = new InMemoryTaskManager();
        return taskManager;
    }


}
