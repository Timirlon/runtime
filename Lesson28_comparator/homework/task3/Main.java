package Lesson28_comparator.homework.task3;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));

        System.out.println(getCommonValues(list1, list2));
    }

    public static ArrayList<Integer> getCommonValues(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> commonValues = new ArrayList<>();
        for (int number1 : list1) {
            if (list2.contains(number1)) {
                commonValues.add(number1);
            }
        }

        return commonValues;
    }
}
