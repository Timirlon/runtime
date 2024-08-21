package Lesson39_lambda_function.homework_function_predicate_unary_operator.task10_sort_list_and_to_lower_case;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<List<String>> sortAndLowerCase = strings -> {
            strings.sort(new MyComparator());

            List<String> newList = new ArrayList<>();
            for (String string : strings) {
                newList.add(string.toLowerCase());
            }

            return newList;
        };

        List<String> countries = new ArrayList<>();
        countries.add("Казахстан");
        countries.add("Уганда");
        countries.add("Германия");
        countries.add("Франция");


        System.out.println(sortAndLowerCase.apply(countries));
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
