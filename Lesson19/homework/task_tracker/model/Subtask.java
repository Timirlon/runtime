package Lesson19.homework.task_tracker.model;

import java.time.LocalDateTime;

public class Subtask extends Task {
    private final Epic epic;

    public Subtask(String title, String description, Epic epic) {
        super(title, description);
        this.epic = epic;
        epic.addSubtask(this);
        type = Type.SUBTASK;
    }

    public Subtask(String title, String description, Epic epic, LocalDateTime startTime, int duration) {
        super(title, description, startTime, duration);
        this.epic = epic;
        epic.addSubtask(this);
    }

    public Subtask(int id, String title, String description, Status status, Epic epic) {
        this(title, description, epic);
        this.id = id;
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
