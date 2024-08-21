package Lesson39_lambda_function.homework_function_predicate_unary_operator.task2_getting_long_words;

import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<List<String>> uo = list -> {
            List<String> newList = new ArrayList<>();
            for (String element : list) {
                if (element.length() > 7) {
                    newList.add(element);
                }
            }
            return newList;
        };

        List<String> stringList = List.of("Яблоко", "Дыня", "Виноград", "Банан", "Клубника");
        System.out.println(uo.apply(stringList));
    }
}
