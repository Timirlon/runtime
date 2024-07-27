package Lesson32_string.classwork.task4;

public class SubstringFunctions {
    public static boolean startsWith(String initial, String other) {
        return initial.indexOf(other) == 0;
    }

    public static boolean endsWith(String initial, String other) {
        return initial.lastIndexOf(other) == initial.length() - other.length();
    }

    public static void main(String[] args) {
        System.out.println(startsWith("Александр", "Алекс"));
        System.out.println(endsWith("каркар", "кар"));
    }
}
