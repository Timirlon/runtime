package Lesson32_string.homework.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "Java удивительный язык программирования";
        System.out.println("Самое длинное слово в предложении: " + findLongestWord(text));
    }

    public static String findLongestWord (String text) {
        List<String> words = new ArrayList<>();

        String curWord = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).isBlank()) {
                words.add(curWord);
                curWord = "";
                continue;
            }
            curWord += text.substring(i, i + 1);

            if (i == text.length() - 1) {
                words.add(curWord);
            }
        }

        String longestWord = words.get(0);
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}
