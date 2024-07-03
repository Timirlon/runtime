package Lesson19.homework.task_tracker;

public class Managers {
    public static HistoryManager getDefault() {
        return new InMemoryHistoryManager();
    }
}
