package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.utils.*;
import java.io.*;
import java.nio.file.Path;
import java.util.Map;
import java.util.List;

public class FileBackedTaskManager extends InMemoryTaskManager {
    private final Path path;

    public FileBackedTaskManager(Path path) {
        this.path = path;
    }
    public void save() {
        try {
            Writer writer = new FileWriter(path.toFile()); //""

            writer.write("id,type,name,status,description,epic\n");

            for (Map.Entry<Integer, Task> entrySet : getTasks().entrySet()) {
                writer.write(toString(entrySet.getValue()));
                writer.write("\n");
            }

            for (Map.Entry<Integer, Epic> entrySet : getEpics().entrySet()) {
                writer.write(toString(entrySet.getValue()));
                writer.write("\n");
            }

            for (Map.Entry<Integer, Subtask> entrySet : getSubtasks().entrySet()) {
                writer.write(toString(entrySet.getValue()));
                writer.write("\n");
            }

            writer.close();

        } catch (IOException io) {
            throw new ManagerSaveException();
        }
    }

    public String toString(Task task) {
        return task.toString();
    }

    public Task fromString(String value) {
        String[] split = value.split(",");
        int taskId = Integer.parseInt(split[0]);
        Type type = Type.valueOf(split[1]);
        String name = split[2];
        Status status = Status.valueOf(split[3]);
        String description = split[4];
        Task task;
        switch (type) {
            case TASK:
                task = new Task(name, description);
                task.setType(Type.TASK);
                break;
            case EPIC:
                task = new Epic(name, description);
                task.setType(Type.EPIC);
                break;
            case SUBTASK:
                int epicId = Integer.parseInt(split[5]);
                task = new Subtask(name, description, epics.get(epicId));
                task.setType(Type.SUBTASK);
            default:
                return null;
        }
        task.setId(taskId);
        task.setStatus(status);

        return task;
    }

    static String historyToString(HistoryManager historyManager) {
        List<Task> history = historyManager.getHistory();
        StringBuilder stringBuilder = new StringBuilder();

        for (Task task : history) {
            stringBuilder.append(task.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    static FileBackedTaskManager loadFromFile(Path path) throws IOException {
        FileBackedTaskManager fileBackedTaskManager = new FileBackedTaskManager(/*Managers.getDefault()*/ path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()));
        bufferedReader.readLine();

        while (bufferedReader.ready()) {
            Task task = fileBackedTaskManager.fromString(bufferedReader.readLine());

            switch (task.getType()) {
                case TASK:
                    fileBackedTaskManager.tasks.put(task.getId(), task);
                    break;
                case EPIC:
                    fileBackedTaskManager.epics.put(task.getId(), (Epic) task);
                    break;
                case SUBTASK:
                    fileBackedTaskManager.subtasks.put(task.getId(), (Subtask) task);
                    break;
            }
        }

        return fileBackedTaskManager;

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

    public static void main(String[] args) throws IOException {
        FileBackedTaskManager fbtm = loadFromFile(Managers.getPath());

        System.out.println(fbtm.getHistory());

        fbtm.createSubtask(new Subtask("Лечь пораньше", "Ты потом не сможешь встать!", fbtm.epics.get(1)));

        System.out.println(fbtm.getHistory());
    }
}
