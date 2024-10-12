package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.utils.Managers;

public class FileBackedTaskManagerTest extends TaskManagerTest<FileBackedTaskManager> {
    public FileBackedTaskManagerTest() {
        super(Managers.getDefault());
    }
}