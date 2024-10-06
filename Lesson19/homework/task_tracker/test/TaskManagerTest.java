package Lesson19.homework.task_tracker.test;

import Lesson19.homework.task_tracker.model.Task;
import Lesson19.homework.task_tracker.service.TaskManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class TaskManagerTest<T extends TaskManager> {
    private final T taskManager;

    public TaskManagerTest(T taskManager) {
        this.taskManager = taskManager;
    }

    @Test
    public void historyHasToBeNullIfGetTaskMethodsNotCalled() {
        assertNull(taskManager.getHistory());
    }

    @Test
    public void historyHasToContainTaskIfGetTaskMethodsCalled() {
        taskManager.createTask(new Task("test1", "test1"));

        taskManager.getTaskById(1);
    }
}
