package Lesson39_lambda_function.homework_function_predicate_unary_operator.task3_filter_by_first_letter;


import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<List<String>> unaryOperator = list -> {
            List<String> newList = new ArrayList<>();
            for (String element : list) {
                if (element.substring(0, 1).equalsIgnoreCase("А")) {
                    newList.add(element);
                }
            }
            return newList;
        };

        List<String> stringList = List.of("Яблоко", "Абрикос", "Виноград", "арбуз", "Клубника");

        System.out.println(unaryOperator.apply(stringList));
    }
}
