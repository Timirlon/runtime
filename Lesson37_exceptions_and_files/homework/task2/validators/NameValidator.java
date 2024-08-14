package Lesson37_exceptions_and_files.homework.task2.validators;

import Lesson37_exceptions_and_files.homework.task2.exceptions.ValidateException;
import Lesson37_exceptions_and_files.homework.task2.exceptions.ValidateNameException;

public class NameValidator implements Validator {
    @Override
    public void validate(final String name) throws ValidateException {
        if (name.isBlank()) {
            throw new ValidateNameException("Имя не может быть пустым!");
        }
    }
}