package Lesson19.homework.task_tracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Epic extends Task {
    private final ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(String title, String description) {
        super(title, description);
        this.setStatusForEpic();
        type = Type.EPIC;
    }

    public Epic(int id, String title, String description, Status status) {
        super(id, title, description, status);
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
        setStatusForEpic();
    }

    protected void setStatusForEpic () {
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


    public void setStartTimeForEpic() {
        LocalDateTime earliestStartTime = subtasks.get(0).getStartTime();

        if (earliestStartTime == null) {
            return;
        }

        for (Subtask subtask : subtasks) {
            LocalDateTime someStartTime = subtask.getStartTime();

            if (someStartTime.isBefore(earliestStartTime)) {
                earliestStartTime = someStartTime;
            }
        }

        startTime = earliestStartTime;
    }

    @Override
    public LocalDateTime getEndTime() {
        LocalDateTime latestEndTime = subtasks.get(0).getEndTime();

        for (Subtask subtask : subtasks) {
            LocalDateTime someEndTime = subtask.getEndTime();

            if (someEndTime.isAfter(latestEndTime)) {
                latestEndTime = someEndTime;
            }
        }

        return latestEndTime;
    }
}
