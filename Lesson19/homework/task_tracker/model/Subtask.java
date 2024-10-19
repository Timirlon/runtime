package Lesson19.homework.task_tracker.model;

import java.time.LocalDateTime;

public class Subtask extends Task {
    private final Epic epic;

    public Subtask(String title, String description, Epic epic) {
        super(title, description);

        this.epic = epic;
        epic.addSubtask(this);
        setType(Type.SUBTASK);
    }

    public Subtask(String title, String description, LocalDateTime startTime, int duration, Epic epic) {
        super(title, description, startTime, duration);

        this.epic = epic;
        epic.addSubtask(this);
        setType(Type.SUBTASK);
    }

    public Subtask(int id, String title, String description, Status status, Epic epic) {
        super(id, title, description, status);

        this.epic = epic;
        epic.addSubtask(this);
        setType(Type.SUBTASK);
    }

    public Subtask(int id, String title, String description, Status status, LocalDateTime startTime, int duration, Epic epic) {
        super(id, title, description, status, startTime, duration);

        this.epic = epic;
        epic.addSubtask(this);
        setType(Type.SUBTASK);
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        epic.setStatus();
    }

    @Override
    public String toString() {
        return super.toString() + "," + getEpic().getId();
    }
}
