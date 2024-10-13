package Lesson19.homework.task_tracker.model;

import java.time.LocalDateTime;

public class Task {
    protected int id;
    protected String title;
    protected String description;
    protected Status status;
    protected Type type;
    protected LocalDateTime startTime;
    protected int duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
        type = Type.TASK;
    }

    public Task(String title, String description, LocalDateTime startTime, int duration) {
        this(title, description);
        this.startTime = startTime;
        this.duration = duration;
    }

    public Task(int id, String title, String description, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.type = Type.TASK;
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

    public void setStartTime(LocalDateTime startTime) {
        this.startTime =  startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getEndTime() {
        return startTime.plusMinutes(duration);
    }

    @Override
    public String toString() {
        return getId() + "," + getType() + "," + getTitle() + "," + getStatus() + "," + getDescription();
    }
}
