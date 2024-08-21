package Lesson39_lambda_function.homework_function_predicate_unary_operator.task7_multiplication;

import java.util.List;
import java.util.function.Function;

public class Practice {
    public static void main(String[] args) {
        Function<List<Integer>, Integer> function = integers -> {
            int mult = 1;
            for (int element : integers) {
                mult *= element;
            }
            return mult;
        };

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(function.apply(integerList));
    }
}
