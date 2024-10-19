package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.exceptions.ManagerSaveException;
import Lesson19.homework.task_tracker.model.*;
import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;

public class FileBackedTaskManager extends InMemoryTaskManager {
    private final Path path;

    public FileBackedTaskManager(Path path) {
        this.path = path;
    }
    public void save() {
        try {
            Writer writer = new FileWriter(path.toFile());

            writer.write("id,type,name,status,description,startTime,duration,epic\n");

            for (Task task : getPrioritizedTasks()) {

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

    private Task getTaskFromString(String value) {
        String[] split = value.split(",");
        int taskId = Integer.parseInt(split[0]);
        Type type = Type.valueOf(split[1]);
        String name = split[2];
        Status status = Status.valueOf(split[3]);
        String description = split[4];

        LocalDateTime startTime = split[5].equals("null") ? null : LocalDateTime.parse(split[5]);

        int duration = Integer.parseInt(split[6]);

        if (taskId > uniqueId) {
            uniqueId = taskId + 1;
        }

        Task task = null;
        switch (type) {
            case TASK:
                task = new Task(taskId, name, description, status, startTime, duration);
                break;
            case EPIC:
                task = new Epic(taskId, name, description, status, startTime, duration);
                break;
            case SUBTASK:
                int epicId = Integer.parseInt(split[7]);
                task = new Subtask(taskId ,name, description, status, startTime, duration, epics.get(epicId));
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

    public static FileBackedTaskManager loadFromFile(Path path) throws IOException {
        FileBackedTaskManager taskManager = new FileBackedTaskManager(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()));
        bufferedReader.readLine();

        while (bufferedReader.ready()) {
            String restoredTask = bufferedReader.readLine();

            if (restoredTask.isBlank()) {
                break;
            }

            Task task = taskManager.getTaskFromString(restoredTask);

            switch (task.getType()) {
                case TASK:
                    taskManager.tasks.put(task.getId(), task);
                    break;
                case EPIC:
                    taskManager.epics.put(task.getId(), (Epic) task);
                    break;
                case SUBTASK:
                    taskManager.subtasks.put(task.getId(), (Subtask) task);
                    break;
            }
        }

        String protoHistory = bufferedReader.readLine();

        if (protoHistory == null || protoHistory.isBlank()) {
            return taskManager;
        }

        for (int taskId : historyFromString(protoHistory)) {
            taskManager.historyManager.add(taskManager.get(taskId));
        }

        bufferedReader.close();

        return taskManager;
    }

    @Override
    public Task createTask(Task task) {
        Task newTask = super.createTask(task);
        save();

        return newTask;
    }

    @Override
    public Epic createEpic(Epic epic) {
        Epic newEpic = super.createEpic(epic);
        save();

        return newEpic;
    }

    @Override
    public Subtask createSubtask(Subtask subtask) {
        Subtask newSubtask = super.createSubtask(subtask);
        save();

        return newSubtask;
    }

    @Override
    public Task getTask(int id) {
        Task task = super.getTask(id);
        save();

        return task;
    }

    @Override
    public Epic getEpic(int id) {
        Epic epic = super.getEpic(id);
        save();
        return epic;
    }

    @Override
    public Subtask getSubtask(int id) {
        Subtask subtask = super.getSubtask(id);
        save();
        return subtask;
    }

    @Override
    public Task update(int id, Task updatedValue) {
        Task updatedTask = super.update(id, updatedValue);
        save();
        return updatedTask;
    }

    @Override
    public Task removeTask(int id) {
        Task removedTask = super.removeTask(id);
        save();

        return removedTask;
    }

    @Override
    public Epic removeEpic(int id) {
        Epic removedEpic = super.removeEpic(id);
        save();

        return removedEpic;
    }

    @Override
    public Subtask removeSubtask(int id) {
        Subtask removedSubtask = super.removeSubtask(id);
        save();

        return removedSubtask;
    }
}
