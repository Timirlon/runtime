package Lesson19.homework.task_tracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBackedTaskManager extends InMemoryTaskManager {
    public void save() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
        } catch (IOException io) {
            throw new ManagerSaveException();
        }
    }

    @Override
    public void createSubtask(Subtask subtask) {
        super.createSubtask(subtask);
        save();
    }

    @Override
    public void createTask(Task task) {
        super.createTask(task);
        save();
    }

    @Override
    public void createEpic(Epic epic) {
        super.createEpic(epic);
        save();
    }

    public String toString(Task task) {
        return task.toString();
    }

    public Task fromString(String value) {
        String[] split = value.split(",");
        Task task;
        if (split[1].equals(Type.TASK.name())) {
            task = new Task(split[2], split[4]);
            task.setType(Type.TASK);
        } else if (split[1].equals(Type.EPIC.name())) {
            task = new Epic(split[2], split[4]);
            task.setType(Type.EPIC);
        } else if (split[1].equals(Type.SUBTASK.name())) {
            task = new Subtask(split[2], split[4], getEpics().get(Integer.parseInt(split[5])));
            task.setType(Type.SUBTASK);
        } else {
            return null;
        }
        task.setId(Integer.parseInt(split[0]));
        task.setStatus(split[3].equals(Status.DONE.name()) ? Status.DONE : split[1].equals(Status.NEW.name()) ? Status.NEW : split[1].equals(Status.IN_PROGRESS.name()) ? Status.IN_PROGRESS : null);

        return task;
    }

    static String historyToString(HistoryManager manager) {
        String string = "";
        return string;
    }

    static List<Integer> historyFromString(String value) {
        List<Integer> history = new ArrayList<>();
        String[] split = value.split("\n");

        return history;
    }
}
