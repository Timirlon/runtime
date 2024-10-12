package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    Epic epic;

    public void addSubtasksToEpic() {
        Subtask subtask = new Subtask("Test title", "Test desc", epic);
        Subtask subtask2 = new Subtask("Test title2", "Test desc", epic);

        epic.addSubtask(subtask);
        epic.addSubtask(subtask2);
    }

    @BeforeEach
    public void initializeEpic() {
        epic = new Epic("test title", "test description");
    }

    @Test
    public void statusOfEpicShouldBeNewIfSubtasksEmpty() {
        assertEquals(Status.NEW, epic.getStatus());
    }

    @Test
    public void statusOfEpicShouldBeNewIfAllSubtasksNew() {
        addSubtasksToEpic();

        assertEquals(Status.NEW, epic.getStatus());
    }

    @Test
    public void statusOfEpicShouldBeDoneIfAllSubtasksDone() {
        addSubtasksToEpic();

        epic.getSubtasks().get(0).setStatus(Status.DONE);
        epic.getSubtasks().get(1).setStatus(Status.DONE);

        assertEquals(Status.DONE, epic.getStatus());
    }

    @Test
    public void statusOfEpicShouldBeInProgressIfAllSubtasksInProgress() {
        addSubtasksToEpic();

        epic.getSubtasks().get(0).setStatus(Status.IN_PROGRESS);
        epic.getSubtasks().get(1).setStatus(Status.IN_PROGRESS);

        for (Subtask task : epic.getSubtasks()) {
            assertEquals(Status.IN_PROGRESS, task.getStatus());
        }
        assertEquals(Status.IN_PROGRESS, epic.getStatus());
    }

    @Test
    public void statusOfEpicShouldBeInProgressInOtherCase() {
        addSubtasksToEpic();

        epic.getSubtasks().get(0).setStatus(Status.DONE);

        assertEquals(Status.IN_PROGRESS, epic.getStatus());
    }
}