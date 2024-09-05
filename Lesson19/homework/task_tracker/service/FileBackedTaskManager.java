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

            writer.close();

        } catch (IOException io) {
            throw new ManagerSaveException();
        }
    }

    public Task getTaskFromString(String value) {
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
                task = new Subtask(taskId ,name, description, status, getEpicById(epicId));
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
            Task task = fileBackedTaskManager.getTaskFromString(bufferedReader.readLine());

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

        fbtm.createTask(new Task("Сходить в магазин", "default"));
        fbtm.createEpic(new Epic("Убраться дома", "пора навести порядок!"));

        fbtm.createSubtask(new Subtask("Помыть посуду", "default", fbtm.epics.get(2)));
        fbtm.createSubtask(new Subtask("Пропылесосить", "default", fbtm.epics.get(2)));

        System.out.println(fbtm.getHistory());
    }
}
