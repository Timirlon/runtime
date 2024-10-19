package Lesson19.homework.task_tracker.test;

import Lesson19.homework.task_tracker.service.FileBackedTaskManager;
import Lesson19.homework.task_tracker.utils.Managers;

public class FileBackedTaskManagerTest extends TaskManagerTest<FileBackedTaskManager> {
    public FileBackedTaskManagerTest() {
        super(new FileBackedTaskManager(Managers.getTestPath()));
    }
}