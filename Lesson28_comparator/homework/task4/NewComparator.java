package Lesson28_comparator.homework.task4;

import java.util.Comparator;

public class NewComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x1, Integer x2) {
        return x1 - x2;
    }
}
