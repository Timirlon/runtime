package Lesson39_lambda_function.homework_function_predicate_unary_operator.task12_sum_of_even_nums;

import java.util.function.Function;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        Function<List<Integer>, Integer> summarizeEvenNums = integers -> {
            int sum = 0;
            for (int integer : integers) {
                if (integer % 2 == 0) {
                    sum += integer;
                }
            }
            return sum;
        };

        List<Integer> someRandomNums = List.of(24, 1, 41, 52, 12, 901, 25);
        System.out.println(summarizeEvenNums.apply(someRandomNums));
    }
}
