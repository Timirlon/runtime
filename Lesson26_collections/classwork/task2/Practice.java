package Lesson26_collections.classwork.task2;

import java.util.List;

public class Practice {
    public static void main(String[] args) {
        final String[] coffeeArray = {"Латте", "Капучино", "Эспрессо"};

        for (String c : coffeeArray) {
            System.out.print(c + ", ");
        }
        System.out.println();

        final List<String> coffeeList = List.of(coffeeArray); // тут массив должен стать списком
        System.out.println(coffeeList);

    }
}
