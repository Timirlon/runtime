package Lesson19.homework.task_tracker.test;

import Lesson19.homework.task_tracker.model.*;
import Lesson19.homework.task_tracker.service.TaskManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public abstract class TaskManagerTest<T extends TaskManager> {
    private final T taskManager;

    public TaskManagerTest(T taskManager) {
        this.taskManager = taskManager;
    }

    @Test
    public void historyHasToBeEmptyIfGetTaskMethodsNotCalled() {
        assertTrue(taskManager.getHistory().isEmpty());
    }

    @Test
    public void historyHasToContainOneTaskIfGetTaskMethodsCalledOnce() {
        Task task = taskManager.createTask(new Task("test1", "test1"));

        taskManager.getTask(1);

        assertEquals(1, taskManager.getHistory().size());
        assertTrue(taskManager.getHistory().contains(task));
    }

    @Test
    public void historyHasToContainThreeTasksIfGetTaskMethodsCalledThrice() {
        Task taskOne = taskManager.createTask(new Task("test1", "test1"));
        Task taskTwo = taskManager.createTask(new Task("test2", "test2"));
        Task taskThree = taskManager.createTask(new Task("test3", "test3"));

        for (int i = 1; i < 4; i++) {
            taskManager.getTask(i);
        }

        assertEquals(3, taskManager.getHistory().size());
        assertTrue(taskManager.getHistory().contains(taskOne));
        assertTrue(taskManager.getHistory().contains(taskTwo));
        assertTrue(taskManager.getHistory().contains(taskThree));
    }

    @Test
    public void getTasksHasToReturnEmptyCollectionIfNoTasksCreated() {
        assertTrue(taskManager.getTasks().isEmpty());
    }

    @Test
    public void getTasksHasToReturnCollectionContainingAllCreatedTasks() {
        Task taskOne = taskManager.createTask(new Task("test1", "test1"));
        Task taskTwo = taskManager.createTask(new Task("test2", "test2"));
        Task taskThree = taskManager.createTask(new Task("test3", "test3"));


        assertEquals(3, taskManager.getTasks().size());
        assertTrue(taskManager.getTasks().contains(taskOne));
        assertTrue(taskManager.getTasks().contains(taskTwo));
        assertTrue(taskManager.getTasks().contains(taskThree));
    }

    @Test
    public void getEpicsHasToReturnEmptyCollectionIfNoEpicsCreated() {
        assertTrue(taskManager.getEpics().isEmpty());
    }

    @Test
    public void getEpicsHasToReturnCollectionContainingAllCreatedEpics() {
        Epic epicOne = taskManager.createEpic(new Epic("test1", "test1"));
        Epic epicTwo = taskManager.createEpic(new Epic("test2", "test2"));
        Epic epicThree = taskManager.createEpic(new Epic("test3", "test3"));


        assertEquals(3, taskManager.getEpics().size());
        assertTrue(taskManager.getEpics().contains(epicOne));
        assertTrue(taskManager.getEpics().contains(epicTwo));
        assertTrue(taskManager.getEpics().contains(epicThree));
    }

    @Test
    public void getSubtasksHasToReturnEmptyCollectionIfNoSubtasksCreated() {
        assertTrue(taskManager.getSubtasks().isEmpty());
    }

    @Test
    public void getSubtasksHasToReturnCollectionContainingAllCreatedSubtasks() {
        Epic epic = taskManager.createEpic(new Epic("test-epic", "test-epic"));

        Subtask subtaskOne = taskManager.createSubtask(new Subtask("test1", "test1", epic));
        Subtask subtaskTwo = taskManager.createSubtask(new Subtask("test2", "test2", epic));
        Subtask subtaskThree = taskManager.createSubtask(new Subtask("test3", "test3", epic));


        assertEquals(3, taskManager.getSubtasks().size());
        assertTrue(taskManager.getSubtasks().contains(subtaskOne));
        assertTrue(taskManager.getSubtasks().contains(subtaskTwo));
        assertTrue(taskManager.getSubtasks().contains(subtaskThree));
    }

    @Test
    public void removeAllMethodShouldLeaveHistoryTasksEpicsAndSubtasksEmpty() {
        Task taskOne = taskManager.createTask(new Task("task-test1", "task-test1"));
        Epic epicOne = taskManager.createEpic(new Epic("epic-test1", "epic-test1"));
        Subtask subtaskOne = taskManager.createSubtask(new Subtask("subtask-test1", "subtask-test1", epicOne));

        taskManager.getTask(1);


        assertFalse(taskManager.getHistory().isEmpty());
        assertFalse(taskManager.getTasks().isEmpty());
        assertFalse(taskManager.getEpics().isEmpty());
        assertFalse(taskManager.getSubtasks().isEmpty());

        taskManager.removeAll();


        assertTrue(taskManager.getHistory().isEmpty());
        assertTrue(taskManager.getTasks().isEmpty());
        assertTrue(taskManager.getEpics().isEmpty());
        assertTrue(taskManager.getSubtasks().isEmpty());
    }

    @Test
    public void getTaskMethodShouldReturnNullIfGivenInvalidIndex() {
        int invalidId = 1;
        assertNull(taskManager.getTask(invalidId));
    }

    @Test
    public void getTaskShouldReturnRequestedTaskIfAllConditionsAreMet() {
        Task task = taskManager.createTask(new Task("test", "test"));

        assertEquals(task, taskManager.getTask(task.getId()));
    }

    @Test
    public void getEpicMethodShouldReturnNullIfGivenInvalidIndex() {
        int invalidId = 1;
        assertNull(taskManager.getEpic(invalidId));
    }

    @Test
    public void getEpicShouldReturnRequestedEpicIfAllConditionsAreMet() {
        Epic epic = taskManager.createEpic(new Epic("test", "test"));

        assertEquals(epic, taskManager.getEpic(epic.getId()));
    }

    @Test
    public void getSubtaskMethodShouldReturnNullIfGivenInvalidIndex() {
        int invalidId = 1;
        assertNull(taskManager.getSubtask(invalidId));
    }

    @Test
    public void getSubtaskShouldReturnRequestedSubtaskIfAllConditionsAreMet() {
        Epic testEpic = taskManager.createEpic(new Epic("epic-test", "epic-test"));

        Subtask subtask = taskManager.createSubtask(new Subtask("test", "test", testEpic));

        assertEquals(subtask, taskManager.getSubtask(subtask.getId()));
    }

    @Test
    public void removeTaskMethodShouldReturnNullIfGivenInvalidIndex() {
        int invalidId = 2;
        assertNull(taskManager.removeTask(invalidId));
    }

    @Test
    public void removeTaskMethodShouldRunSuccessfullyIfAllConditionsAreMet() {
        Task task = new Task("test", "test");

        taskManager.createTask(task);

        int numberOfTasks = taskManager.getTasks().size();

        assertEquals(task, taskManager.removeTask(task.getId()));
        assertEquals(numberOfTasks - 1, taskManager.getTasks().size());
    }

    @Test
    public void removeEpicMethodShouldReturnNullIfGivenInvalidIndex() {
        int invalidId = 2;
        assertNull(taskManager.removeEpic(invalidId));
    }

    @Test
    public void removeEpicMethodShouldRunSuccesfullyIfAllConditionsAreMet() {
        Epic epic = new Epic("test", "test");

        taskManager.createEpic(epic);

        int numberOfEpics = taskManager.getEpics().size();

        assertEquals(epic, taskManager.removeEpic(epic.getId()));
        assertEquals(numberOfEpics - 1, taskManager.getEpics().size());
        assertFalse(taskManager.getEpics().contains(epic));
    }

    @Test
    public void removeEpicMethodShouldRemoveEverySubtaskAssociatedWithGivenEpic() {
        Epic epic = new Epic("test", "test");
        Subtask subtask = new Subtask("subtask-test", "subtask-test", epic);

        taskManager.createEpic(epic);
        taskManager.createSubtask(subtask);

        int numberOfSubtasks = taskManager.getSubtasks().size();

        taskManager.removeEpic(epic.getId());

        assertFalse(taskManager.getSubtasks().contains(subtask));
        assertEquals(numberOfSubtasks - 1, taskManager.getSubtasks().size());
    }

    @Test
    public void removeSubtaskMethodShouldReturnNullIfGivenIncorrectIndex() {
        int invalidId = 1;
        assertNull(taskManager.removeSubtask(invalidId));
    }

    @Test
    public void removeSubtaskMethodShouldRunSuccessfullyIfConditionsAreMet() {
        Epic epic = new Epic("epic-test", "epic-test");
        Subtask subtask = new Subtask("subtask-test", "subtask-test", epic);

        taskManager.createEpic(epic);
        taskManager.createSubtask(subtask);
        int subtasksNumInManager = taskManager.getSubtasks().size();
        int subtasksNumInEpic = epic.getSubtasks().size();

        assertEquals(subtask, taskManager.removeSubtask(subtask.getId()));
        assertFalse(taskManager.getSubtasks().contains(subtask));
        assertEquals(subtasksNumInManager - 1, taskManager.getSubtasks().size());
        assertFalse(epic.getSubtasks().contains(subtask));
        assertEquals(subtasksNumInEpic - 1, epic.getSubtasks().size());
    }

    @Test
    public void createTaskShouldReturnNullIfTimeOfGivenTaskIsIntersecting() {
        Task originalTask = new Task("test", "test", LocalDateTime.of(2024, 10, 17, 12, 0), 120);
        taskManager.createTask(originalTask);

        Task testTask = new Task("test", "test", LocalDateTime.of(2024, 10, 17, 13, 0), 120);
        Task result = taskManager.createTask(testTask);

        assertNull(result);
        assertEquals(1, taskManager.getTasks().size());
        assertFalse(taskManager.getTasks().contains(testTask));
    }

    @Test
    public void createTaskShouldCreateAndReturnGivenTask() {
        Task task = new Task("test", "test");

        Task returnValue = taskManager.createTask(task);

        assertEquals(task, returnValue);
        assertEquals(1, taskManager.getTasks().size());
        assertTrue(taskManager.getTasks().contains(task));
    }

    @Test
    public void createEpicShouldCreateAndReturnGivenEpic() {
        Epic epic = new Epic("test", "test");

        Epic returnValue = taskManager.createEpic(epic);

        assertEquals(epic, returnValue);
        assertEquals(1, taskManager.getEpics().size());
        assertTrue(taskManager.getEpics().contains(epic));
    }

    @Test
    public void createSubtaskShouldCreateAndReturnGivenSubtask() {
        Epic epic = new Epic("test", "test");
        Subtask subtask = new Subtask("test", "test", epic);

        taskManager.createEpic(epic);
        Subtask returnValue = taskManager.createSubtask(subtask);

        assertEquals(subtask, returnValue);
        assertEquals(1, taskManager.getSubtasks().size());
        assertTrue(taskManager.getSubtasks().contains(subtask));
    }
}
