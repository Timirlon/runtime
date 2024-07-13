package Lesson28_comparator.homework.task1;

import java.util.Comparator;

public class HandMadeComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x1, Integer x2) {
        return x2 - x1;
    }
}
