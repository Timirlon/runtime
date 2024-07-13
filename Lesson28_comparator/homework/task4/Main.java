package Lesson28_comparator.homework.task4;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int size = 10;
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }

        Collections.sort(list, new NewComparator());

        System.out.println(list);
    }
}
