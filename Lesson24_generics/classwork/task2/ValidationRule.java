package Lesson24_generics.classwork.task2;

public abstract class ValidationRule<T> {
    protected final T value;
    private final String errorMessage;

    protected ValidationRule(T value, String errorMessage) {
        this.value = value;
        this.errorMessage = errorMessage;
    }

    public abstract boolean isValid();

    public String getErrorMessage() {
        return errorMessage;
    }
}
