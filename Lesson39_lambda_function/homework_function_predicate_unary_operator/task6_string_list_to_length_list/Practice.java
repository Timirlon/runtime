package Lesson39_lambda_function.homework_function_predicate_unary_operator.task6_string_list_to_length_list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Practice {
    public static void main(String[] args) {
        Function<List<String>, List<Integer>> function = stringList -> {
            List<Integer> lengthList = new ArrayList<>();
            for (String element : stringList) {
                lengthList.add(element.length());
            }
            return lengthList;
        };

        List<String> toDoList = List.of("Сделать домашку", "Приготовить кушать", "Стирка");
        System.out.println(function.apply(toDoList));
    }
}
