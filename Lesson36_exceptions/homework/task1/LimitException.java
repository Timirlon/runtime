package Lesson36_exceptions.homework.task1;

public class LimitException extends RuntimeException {
    public LimitException(String message) {
        super(message);
    }
}
