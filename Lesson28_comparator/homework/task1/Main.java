package Lesson28_comparator.homework.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 2, 8, 1, 9, 3, 7, 4, 6));

        Collections.sort(numbers, new HandMadeComparator());

        System.out.println(numbers.get(1));
    }
}
