package Lesson35_string_format_and_exceptions.classwork.task2_exception;

import java.net.URI;

public class Practice {
    public static void main(String[] args) {
        System.out.println(parseStringToURI("https://google.com"));
        System.out.println(parseStringToURI("\\\\"));
        System.out.println(parseStringToURI(null));
    }

    public static URI parseStringToURI(final String input) {
        try {
            return new URI(input);
        } catch (Throwable exception) {
            return null;
        }
    }
}
