package Lesson19.homework.task_tracker;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(String title, String description) {
        super(title, description);
        this.setStatusForEpic();
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setStatusForEpic () {
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
}
