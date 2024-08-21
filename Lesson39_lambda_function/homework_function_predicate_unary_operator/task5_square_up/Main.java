package Lesson39_lambda_function.homework_function_predicate_unary_operator.task5_square_up;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<List<Integer>> uo = someList -> {
            List<Integer> newList = new ArrayList<>();
            for (int element : someList) {
                newList.add(element * element);
            }
            return newList;
        };

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        System.out.println(uo.apply(integerList));
    }
}
