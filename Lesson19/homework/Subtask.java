package Lesson19.homework;

public class Subtask extends Task {
    private Epic epic;

    public Subtask(String title, String description, Epic epic) {
        super(title, description);
        this.epic = epic;
        epic.getSubtasks().add(this);
    }

    public Epic getEpic () {
        return epic;
    }

    @Override
    public void setStatus(String status) {
        super.setStatus(status);
        epic.setStatusForEpic();
    }
}
