package Lesson19.homework.task_tracker;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    static String historyToString(HistoryManager historyManager) {
        List<Task> history = historyManager.getHistory();
        StringBuilder stringBuilder = new StringBuilder();

        for (Task task : history) {
            stringBuilder.append(task.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    static List<Integer> historyFromString(String value) {
        List<Integer> history = new ArrayList<>();
        String[] split = value.split("\n");

        return history;
    }

    static FileBackedTaskManager loadFromFile(Path path) throws IOException {
        FileBackedTaskManager fileBackedTaskManager = new FileBackedTaskManager(/*new Managers.getDefault()*/ path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()));
        bufferedReader.readLine();

        while (bufferedReader.ready()) {
            Task task = fileBackedTaskManager.fromString(bufferedReader.readLine());
            fileBackedTaskManager.createTask(task);
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
        FileBackedTaskManager fbtm = loadFromFile(Path.of("Lesson19\\homework\\for_task_tracker\\history.csv"));

        System.out.println(fbtm.getHistory());

        Epic epic = new Epic("Подготовиться к школе", "Описание эпика");
        fbtm.createEpic(epic);
        fbtm.createSubtask(new Subtask("Сделать уроки", "Описание подзадачи", epic));
        fbtm.createSubtask(new Subtask("Приготовить форму", "Описание подзадачи", epic));

        System.out.println(fbtm.getHistory());
    }
}
