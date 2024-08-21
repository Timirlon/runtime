package Lesson39_lambda_function.homework_function_predicate_unary_operator.task9_return_longest_string;

import java.util.function.Function;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        Function<List<String>, String> longestString = strings -> {
            String maxLength = strings.get(0);
            for (String string : strings) {
                if (string.length() > maxLength.length()) {
                    maxLength = string;
                }
            }
            return maxLength;
        };

        List<String> toDoList = List.of("Сделать домашку", "Приготовить кушать", "Стирка");

        System.out.println(longestString.apply(toDoList));
    }
}
