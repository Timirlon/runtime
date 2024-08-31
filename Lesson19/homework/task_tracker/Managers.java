package Lesson19.homework.task_tracker;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Managers {
    private static final String FILE_PATH = "Lesson19\\homework\\for_task_tracker\\history.csv";

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
