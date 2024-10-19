package Lesson19.homework.task_tracker.utils;

import Lesson19.homework.task_tracker.service.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Managers {
    private static final String FILE_PATH = "Lesson19\\homework\\task_tracker\\files\\file-task-tracking.csv";
    private static final String TEST_FILE_PATH = "Lesson19\\homework\\task_tracker\\files\\test-task-tracking.csv";

    private Managers() {

    }
    public static FileBackedTaskManager getDefault() {
        return new FileBackedTaskManager(getPath());
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static Path getPath() {
        return Paths.get(FILE_PATH);
    }

    public static Path getTestPath() {
        return Paths.get(TEST_FILE_PATH);
    }
}
