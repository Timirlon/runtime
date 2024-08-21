package Lesson39_lambda_function.homework_function_predicate_unary_operator.task8_list_contains_negative;

import java.util.List;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        Predicate<List<Integer>> containsNeg = integers -> {
            for (int element : integers) {
                if (element < 0) {
                    return true;
                }
            }
            return false;
        };

        List<Integer> firstList = List.of(0, 1, 2, 3, 4);
        List<Integer> secondList = List.of(-2, 10, 4, 6, 2);

        System.out.println(containsNeg.test(firstList));
        System.out.println(containsNeg.test(secondList));
    }
}
