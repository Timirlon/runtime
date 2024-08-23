package Lesson40_stream.classwork.task2;

import java.util.List;

public class EvenNumberTask {
    public static void main(String[] args) {
        List<Integer> genericNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = genericNumbers.stream()
                .filter(genericNumber -> genericNumber % 2 == 0 && genericNumber != 0)
                .toList();

        System.out.println(evenNumbers);
    }
}
