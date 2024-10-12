package Lesson19.homework.task_tracker.model;

public class Subtask extends Task {
    private final Epic epic;

    public Subtask(String title, String description, Epic epic) {
        super(title, description);
        this.epic = epic;
        epic.getSubtasks().add(this);
        setType(Type.SUBTASK);
    }

    public Subtask(int id, String title, String description, Status status, Epic epic) {
        this(title, description, epic);
        this.status = status;
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        epic.setStatusForEpic();
    }

    @Override
    public String toString() {
        return super.toString() + "," + getEpic().getId();
    }
}
