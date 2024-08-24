package Lesson19.homework.task_tracker;

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
    private Type type;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
        setType(Type.TASK);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getId() + "," + getType() + "," + getTitle() + "," + getStatus() + "," + getDescription();
    }
}
