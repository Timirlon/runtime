package Lesson37_exceptions_and_files.homework.task1;

public class IncorrectInputException extends Exception {
    public IncorrectInputException(String message) {
        super(message);
    }
}
