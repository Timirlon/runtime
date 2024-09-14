package Lesson19.homework.task_tracker.utils;

import Lesson19.homework.task_tracker.service.FileBackedTaskManager;
import Lesson19.homework.task_tracker.service.HistoryManager;
import Lesson19.homework.task_tracker.service.InMemoryHistoryManager;
import Lesson19.homework.task_tracker.service.TaskManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Managers {
    private static final String FILE_PATH = "Lesson19\\homework\\task_tracker\\files\\history.csv";

    private Managers() {

    }
    public static TaskManager getDefault() {
        return new FileBackedTaskManager(getPath());
    }
    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static Path getPath() {
        return Paths.get(FILE_PATH);
    }
}
