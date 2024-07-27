package Lesson32_string.homework.task1;

public class Main {
    public static void main(String[] args) {
        String sentence = "Сегодня отличный день для программирования";
        System.out.println("Количество слов в предложении: " + countWordsInString(sentence));
    }

    public static int countWordsInString (String text) {
        int count = 1;
        if (text.isBlank()) {
            return 0;
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i+1).isBlank()) {
                count++;
            }
        }
        return count;
    }
}
