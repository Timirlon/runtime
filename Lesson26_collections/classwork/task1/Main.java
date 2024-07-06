package Lesson26_collections.classwork.task1;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final List<String> cats = new ArrayList<>();

        cats.add("Маркиз");
        cats.add("Принцесса");
        cats.add("Пирожок");
        cats.add("Мурка");

        System.out.println(cats); // сейчас печатается [Маркиз, Принцесса, Пирожок, Мурка]

        cats.remove(1);
        cats.remove(2);

        cats.add("Лев");
        System.out.println(cats);
    }
}
