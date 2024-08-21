package Lesson39_lambda_function.homework_function_predicate_unary_operator.task4_to_upper_case;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<List<String>> unaryOperator = someList -> {
            List<String> newList = new ArrayList<>();
            for (String element : someList) {
                newList.add(element.toUpperCase());
            }
            return newList;
        };

        List<String> stringList = new ArrayList<>();
        fillList(stringList);

        System.out.println(unaryOperator.apply(stringList));
    }

    static void fillList(List<String> randomList) {
        randomList.add("Яблоко");
        randomList.add("Дыня");
        randomList.add("Виноград");
        randomList.add("Банан");
        randomList.add("Клубника");
    }
}
