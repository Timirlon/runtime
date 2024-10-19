package Lesson19.homework.task_tracker.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Epic extends Task {
    private final ArrayList<Subtask> subtasks = new ArrayList<>();
    protected LocalDateTime endTime;

    public Epic(String title, String description) {
        super(title, description);
        this.setStatus();
        setType(Type.EPIC);
    }

    public Epic(int id, String title, String description, Status status) {
        super(id, title, description, status);
        setType(Type.EPIC);
    }

    public Epic(int id, String title, String description, Status status, LocalDateTime startTime, int duration) {
        super(id, title, description, status, startTime, duration);
        setType(Type.EPIC);
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
        setStatus();
        setStartTime(subtask.getStartTime());
        setEndTime(subtask.getEndTime());
        setDuration();
    }

    protected void setStatus() {
        int newStatus = 0;
        int doneStatus = 0;
        if (subtasks.isEmpty()) {
            this.setStatus(Status.NEW);
            return;
        }

        for (Subtask subtask : subtasks) {
            if (subtask.getStatus() == Status.NEW) {
                newStatus++;
            } else if (subtask.getStatus() == Status.DONE) {
                doneStatus++;
            }
        }

        if (newStatus == subtasks.size()) {
            this.setStatus(Status.NEW);
        } else if (doneStatus == subtasks.size()) {
            this.setStatus(Status.DONE);
        } else {
            this.setStatus(Status.IN_PROGRESS);
        }
    }

    private void setDuration() {
        long minutes = getStartTime().until(endTime, ChronoUnit.MINUTES);

        super.setDuration((int) minutes);
    }

    @Override
    public void setStartTime(LocalDateTime subtaskStartTime) {
        if (subtaskStartTime == null) {
            return;
        }

        if (this.getStartTime() == null || subtaskStartTime.isBefore(this.getStartTime())) {
            super.setStartTime(subtaskStartTime);
        }
    }

    private void setEndTime(LocalDateTime subtaskEndTime) {
        if (subtaskEndTime == null) {
            return;
        }

        if (endTime == null || subtaskEndTime.isAfter(endTime)) {
            endTime = subtaskEndTime;
        }
    }

    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }
}
