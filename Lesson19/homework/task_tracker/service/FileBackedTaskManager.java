package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.exceptions.ManagerSaveException;
import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.utils.*;
import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class FileBackedTaskManager extends InMemoryTaskManager {
    private final Path path;

    public FileBackedTaskManager(Path path) {
        this.path = path;
    }
    public void save() {
        try {
            Writer writer = new FileWriter(path.toFile());

            writer.write("id,type,name,status,description,epic\n");

            for (int i = 1; i <= uniqueId; i++) {
                Task task = getTaskFromAnyMap(i);

                if (task == null) {
                    continue;
                }

                writer.write(task.toString());
                writer.write("\n");
            }

            writer.write("\n");

            writer.write(historyToString(historyManager));

            writer.close();

        } catch (IOException io) {
            throw new ManagerSaveException();
        }
    }

    private Task getTaskFromAnyMap(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        } else if (epics.containsKey(id)) {
            return epics.get(id);
        } else if (subtasks.containsKey(id)) {
            return subtasks.get(id);
        }

        return null;
    }

    Task getTaskFromString(String value) {
        String[] split = value.split(",");
        int taskId = Integer.parseInt(split[0]);
        Type type = Type.valueOf(split[1]);
        String name = split[2];
        Status status = Status.valueOf(split[3]);
        String description = split[4];

        uniqueId = taskId + 1;

        Task task;
        switch (type) {
            case TASK:
                task = new Task(taskId, name, description, status);
                break;
            case EPIC:
                task = new Epic(taskId, name, description, status);
                break;
            case SUBTASK:
                int epicId = Integer.parseInt(split[5]);
                task = new Subtask(taskId ,name, description, status, epics.get(epicId));
                break;
            default:
                return null;
        }

        return task;
    }

    static List<Integer> historyFromString(String restoredValue) {
        String[] split = restoredValue.split(",");

        List<Integer> history = new ArrayList<>();
        for (String someValue : split) {
            history.add(Integer.parseInt(someValue));
        }

        return history;
    }

    static String historyToString(HistoryManager historyManager) {
        List<Task> history = historyManager.getHistory();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < history.size(); i++) {
            stringBuilder.append(history.get(i).getId());

            if (i != history.size() - 1) {
                stringBuilder.append(",");
            }
        }

        return stringBuilder.toString();
    }

    static FileBackedTaskManager loadFromFile(Path path) throws IOException {
        FileBackedTaskManager fbtm = new FileBackedTaskManager(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()));
        bufferedReader.readLine();

        while (bufferedReader.ready()) {
            String restoredTask = bufferedReader.readLine();

            if (restoredTask.isBlank()) {
                break;
            }

            Task task = fbtm.getTaskFromString(restoredTask);

            switch (task.getType()) {
                case TASK:
                    fbtm.tasks.put(task.getId(), task);
                    break;
                case EPIC:
                    fbtm.epics.put(task.getId(), (Epic) task);
                    break;
                case SUBTASK:
                    fbtm.subtasks.put(task.getId(), (Subtask) task);
                    break;
            }
        }

        String protoHistory = bufferedReader.readLine();

        if (protoHistory.isBlank()) {
            return fbtm;
        }

        for (int taskId : historyFromString(protoHistory)) {
            fbtm.historyManager.add(fbtm.getTaskFromAnyMap(taskId));
        }

        bufferedReader.close();

        return fbtm;
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
        Task task = super.getTaskById(id);
        save();
        return task;
    }

    @Override
    public Epic getEpicById(int id) {
        Epic epic = super.getEpicById(id);
        save();
        return epic;
    }

    @Override
    public Subtask getSubtaskById(int id) {
        Subtask subtask = super.getSubtaskById(id);
        save();
        return subtask;
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

    public static void main(String[] args) throws IOException {
        FileBackedTaskManager fbtm = loadFromFile(Managers.getPath());

        fbtm.getSubtaskById(9);

        System.out.println(fbtm.getHistory());
    }
}
