package Lesson19.homework.task_tracker.service;

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

            for (Map.Entry<Integer, Task> entrySet : getTasks().entrySet()) {
                writer.write(entrySet.getValue().toString());
                writer.write("\n");
            }

            for (Map.Entry<Integer, Epic> entrySet : getEpics().entrySet()) {
                writer.write(entrySet.getValue().toString());
                writer.write("\n");
            }

            for (Map.Entry<Integer, Subtask> entrySet : getSubtasks().entrySet()) {
                writer.write(entrySet.getValue().toString());
                writer.write("\n");
            }

            writer.write("\n");

            writer.write(historyToString(historyManager));

            writer.close();

        } catch (IOException io) {
            throw new ManagerSaveException();
        }
    }

    Task getTaskFromAnyMap(int id) {
        Task task;

        if (tasks.containsKey(id)) {
            task = tasks.get(id);
        } else if (epics.containsKey(id)) {
            task = epics.get(id);
        } else if (subtasks.containsKey(id)) {
            task = subtasks.get(id);
        } else {
            return null;
        }

        return task;
    }

    Task getTaskFromString(String value) {
        String[] split = value.split(",");
        int taskId = Integer.parseInt(split[0]);
        Type type = Type.valueOf(split[1]);
        String name = split[2];
        Status status = Status.valueOf(split[3]);
        String description = split[4];
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
        task.setId(taskId);
        task.setStatus(status);

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
            Task task;
            try {
                task = fbtm.getTaskFromString(bufferedReader.readLine());
            } catch (NumberFormatException e) {
                break;
            }

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

        List<Integer> protoHistory;

        try {
            protoHistory = historyFromString(bufferedReader.readLine());
        } catch (NullPointerException e) {
            return fbtm;
        }

        for (int taskId : protoHistory) {
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

        fbtm.getTaskById(2);
        fbtm.getSubtaskById(6);
        fbtm.getEpicById(4);
        System.out.println(fbtm.getHistory());
    }
}
