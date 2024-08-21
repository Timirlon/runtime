package Lesson39_lambda_function.homework_function_predicate_unary_operator.task11_check_if_contains_even;

import java.util.function.Predicate;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Predicate<List<Integer>> containsEvenNum = integers -> {
            for (int integer : integers) {
                if (integer % 2 == 0 && integer != 0) {
                    return true;
                }
            }
            return false;
        };

        List<Integer> noEvenNum = List.of(0, 1, 3, 5, 7, 9);
        List<Integer> withEvenNum = List.of(0, 1, 2, 3, 4, 5);

        System.out.println(containsEvenNum.test(noEvenNum));
        System.out.println(containsEvenNum.test(withEvenNum));
    }
}
