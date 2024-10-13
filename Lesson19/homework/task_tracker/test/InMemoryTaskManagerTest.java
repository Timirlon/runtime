package Lesson19.homework.task_tracker.test;

import Lesson19.homework.task_tracker.service.InMemoryTaskManager;

public class InMemoryTaskManagerTest extends TaskManagerTest<InMemoryTaskManager> {
    public InMemoryTaskManagerTest() {
        super(new InMemoryTaskManager());
    }
}
