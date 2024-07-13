package Lesson28_comparator.homework.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "orange", "grape"));
        char letter = 'a';

        System.out.println(getWordsStartingWith(words, letter));
    }

    public static ArrayList<String> getWordsStartingWith (ArrayList<String> words, char letter) {
        ArrayList<String> newWordList = new ArrayList<>();

        for (String word : words) {
            if (word.startsWith(Character.toString(letter))) {
                newWordList.add(word);
            }
        }
        return newWordList;
    }
}
