package Lesson19.homework.task_tracker.test;

import Lesson19.homework.task_tracker.model.Task;
import Lesson19.homework.task_tracker.service.HistoryManager;
import Lesson19.homework.task_tracker.service.InMemoryHistoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoryManagerTest {
    private HistoryManager historyManager;

    @BeforeEach
    public void beforeEach() {
        this.historyManager = new InMemoryHistoryManager();
    }

    @Test
    public void addTaskShouldNotWorkIfParameterIsNull() {
        Task task = null;

        historyManager.add(task);

        assertTrue(historyManager.getHistory().isEmpty());
    }

    @Test
    public void addTaskShouldRunSuccessfullyIfConditionsAreMet() {
        Task task = new Task("test", "test");

        historyManager.add(task);

        assertEquals(1, historyManager.getHistory().size());
        assertTrue(historyManager.getHistory().contains(task));
    }
}