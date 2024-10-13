package Lesson19.homework.task_tracker.utils;

import Lesson19.homework.task_tracker.model.Task;
import java.util.Comparator;

public class StartTimeComparator implements Comparator<Task> {
    public int compare(Task taskOne, Task taskTwo) {
        if (taskOne.getStartTime() == null && taskTwo.getStartTime() == null) {
            return 0;
        } else if (taskTwo.getStartTime() == null) {
            return -1;
        } else if (taskOne.getStartTime() == null) {
            return 1;
        }


        if (taskOne.getStartTime().isBefore(taskTwo.getStartTime())) {
            return -1;
        } else if (taskOne.getStartTime().isAfter(taskTwo.getStartTime())) {
            return 1;
        } else {
            return 0;
        }
    }
}
