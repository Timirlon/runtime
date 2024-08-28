package Lesson19.homework.task_tracker;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileBackedTaskManager extends InMemoryTaskManager {
    public void save() {
        try {
            Writer writer = new FileWriter("Lesson19\\homework\\for_task_tracker");
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

    @Override
    public Task getTaskById(int id) {
        save();
        return super.getTaskById(id);
    }

    @Override
    public Epic getEpicById(int id) {
        save();
        return super.getEpicById(id);
    }

    @Override
    public Subtask getSubtaskById(int id) {
        save();
        return super.getSubtaskById(id);
    }

    @Override
    public void update(int id, Task updatedTask) {
        super.update(id, updatedTask);
        save();
    }

    @Override
    public void removeTaskById(int id) {
        super.removeTaskById(id);
        save();
    }

    @Override
    public void removeEpicById(int id) {
        super.removeEpicById(id);
        save();
    }

    @Override
    public void removeSubtaskById(int id) {
        super.removeSubtaskById(id);
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


    static FileBackedTaskManager loadFromFile(Path path) throws IOException {
        FileBackedTaskManager fileBackedTaskManager = new FileBackedTaskManager();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Lesson19\\homework\\for_task_tracker"));
        bufferedReader.readLine();

        List<String> stringList = new ArrayList<>();
        while (bufferedReader.ready()) {
            stringList.add(bufferedReader.readLine());
        }



        return fileBackedTaskManager;
    }

}
