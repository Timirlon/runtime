package Lesson32_string.classwork.task5;

public class FindRepeats {
    public static void main(String[] args) {
        int count = numberOfRepeats("раз, раз, раз", "раз");
        System.out.println(count);
    }

    public static int numberOfRepeats(String text, String substring) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.startsWith(substring, i)) {
                count++;
            }
        }
        return count;
    }
}
