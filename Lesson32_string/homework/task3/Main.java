package Lesson32_string.homework.task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Программирование на Java";
        System.out.println(countNumberOfEachLetter(text));
    }

    public static Map<String, Integer> countNumberOfEachLetter (String text) {
        Map<String, Integer> words = new HashMap<>();
        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).isBlank()) {
                continue;
            }

            if (words.containsKey(text.substring(i, i + 1))) {
                words.put(text.substring(i, i + 1), words.get(text.substring(i, i + 1)) + 1);
            } else {
                words.put(text.substring(i, i + 1), 1);
            }
        }

        return words;
    }
}
