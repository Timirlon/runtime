package Lesson39_lambda_function.homework_function_predicate_unary_operator.task1_getting_even_numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<List<Integer>> uo = list -> {
            List<Integer> newList = new ArrayList<>();
            for (int element : list) {
                if (element % 2 == 0 && element != 0) {
                    newList.add(element);
                }
            }
            return newList;
        };

        List<Integer> integerList = List.of(1, 41, 12, 53, 10, 24, 5);

        System.out.println(uo.apply(integerList));
    }
}
