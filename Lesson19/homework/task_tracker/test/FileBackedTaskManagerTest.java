package Lesson19.homework.task_tracker.test;

import Lesson19.homework.task_tracker.service.FileBackedTaskManager;

import static org.junit.jupiter.api.Assertions.*;

public class FileBackedTaskManagerTest extends TaskManagerTest<FileBackedTaskManager> {
    public FileBackedTaskManagerTest(FileBackedTaskManager taskManager) {
        super(taskManager);
    }
}