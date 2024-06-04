package Lesson17.Homework.task3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Apple");
        myList.add("Banana");

        for (int i = 0; i < myList.size(); i++) {
            int count = 1;
            for (int j = i; j < myList.size(); j++) {
                if (j == i) {
                    continue;
                }
                if (myList.get(j).equals(myList.get(i))) {
                    count++;
                    myList.remove(j);
                }
            }
            System.out.println(myList.get(i) + ": " + count);
        }
    }
}
