package Lesson19.homework;

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
            this.setStatus("NEW");
        }

        for (Subtask subtask : subtasks) {
            if (subtask.getStatus().equals("NEW")) {
                newStatus++;
            } else if (subtask.getStatus().equals("DONE")) {
                doneStatus++;
            }
        }

        if (newStatus == subtasks.size()) {
            this.setStatus("NEW");
        } else if (doneStatus == subtasks.size()) {
            this.setStatus("DONE");
        } else {
            this.setStatus("IN PROGRESS");
        }
    }
}
